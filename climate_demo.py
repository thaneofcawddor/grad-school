# -*- coding: utf-8 -*-
# written by Thane

import pandas as pd

# Define these global variables before running.
SPACING_INTERVAL = 5
DATA_FILE = "python-forthane.csv" # Make sure this file is in the same folder as this script.
MINIMUM_VALUE = None
MAXIMUM_VALUE = None

#come back and define these later
AGE_COLUMN_NAME = 'Age (ka)' 
OUTPUT_FILE_NAME = "interpolated_results.csv"

# Set to 'None' to stick with the maximum values of your dataset (e.g. 1395 for 1397.3 on an interval of 5).
# Changing these values above or below the maximum or minimum, respectively, will
# engage the extrapolation function.


###

raw_data = pd.read_csv('%s' % DATA_FILE, encoding = "utf-8")

### do the check duplicates first because it is an easy example to understand

def checkDuplicates(raw_data):
    averaged_data = raw_data.groupby('%s' % AGE_COLUMN_NAME).mean().reset_index()
    return averaged_data

###

def interpolate(dataframe):
    if MAXIMUM_VALUE is None:
        dataset_maximum = dataframe.loc[:,AGE_COLUMN_NAME].max()
        dataset_maximum = int(SPACING_INTERVAL * round((dataset_maximum-SPACING_INTERVAL)/SPACING_INTERVAL))
    else:
        dataset_maximum = MAXIMUM_VALUE

    if MINIMUM_VALUE is None:
        dataset_minimum = dataframe.loc[:,AGE_COLUMN_NAME].min()
        dataset_minimum = int(SPACING_INTERVAL * round((dataset_minimum+SPACING_INTERVAL)/SPACING_INTERVAL))
    else:
        dataset_minimum = MINIMUM_VALUE

    ### Create a list of all the desired interpolated data points
    desired_dates = pd.Series(range(dataset_minimum, dataset_maximum+1, SPACING_INTERVAL))


    ### Create a dataframe with the data as the index
    new_dataframe = dataframe.set_index(dataframe.loc[:,AGE_COLUMN_NAME])


    ### Combine the intervals with the existing dataset, but not as an index
    df = pd.concat([dataframe.loc[:,AGE_COLUMN_NAME], desired_dates]).sort_values().reset_index()
    

    ### Use the above list to re-index new_dataframe, which will leave null values where there is no data
    new_dataframe = new_dataframe.reindex(df.loc[:,0])


    ### Interpolate the data
    interpolatedDF = new_dataframe.interpolate(method = 'index').drop(dataframe.loc[:,AGE_COLUMN_NAME])


    ### This will delete values that were part of the interval in the original dataset and not interpolated, like 1345 and 1390
    ## Play with and highlight the tilda
    duplicates = dataframe[~dataframe.loc[:,AGE_COLUMN_NAME].isin(desired_dates)]
    print(duplicates)
    duplicates = duplicates.loc[:,AGE_COLUMN_NAME]
    include_non_interpolated = new_dataframe.interpolate(method = 'index').drop(duplicates)

    #print(include_non_interpolated)
    duplicates_removed = include_non_interpolated.drop_duplicates()

    print(duplicates_removed)

    interpolatedDF = interpolatedDF.drop(interpolatedDF.columns[len(interpolatedDF.columns)-1], axis = 'columns')
    return duplicates_removed


cleaned_data = checkDuplicates(raw_data)
interpolated_data = interpolate(cleaned_data)

interpolated_data.to_csv('%s' % OUTPUT_FILE_NAME, index=False)
