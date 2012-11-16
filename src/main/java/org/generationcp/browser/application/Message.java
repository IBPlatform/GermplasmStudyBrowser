package org.generationcp.browser.application;


public enum Message {
	
     WELCOME_TITLE
     ,WELCOME_LABEL
     ,QUESTION_LABEL
     ,GERMPLASM_BUTTON_LABEL
     ,GERMPLASM_LIST_BUTTON_LABEL
     ,STUDY_BUTTON_LABEL
     ,GERMPLASM_BY_PHENO_LABEL
     ,RETRIEVE_GERMPLASM_BY_PHENO_LABEL

     ,GERMPLASM_BY_PHENO_TITLE
     ,GERMPLASM_BROWSER_TITLE
     ,STUDY_BROWSER_TITLE
     ,SEARCH_GERMPLASM_BY_PHENO_TITLE
     ,GERMPLASM_LIST_BROWSER_TITLE

     ,EXPORT_TO_CSV_LABEL
     ,EXPORT_TO_EXCEL_LABEL
     ,SAVE_FIELDBOOK_EXCEL_FILE_LABEL
     ,CANCEL_SAVE_FIELDBOOK_EXCEL_FILE_LABEL
     ,FILE_NAME_LABEL
     ,BROWSE_LABEL
     ,INPUT_FILE_NAME_TEXT
     ,DESTINATION_FOLDER_TEXT
     ,SAVE_FIELDBOOK_EXCEL_FILE_SUCCESSFUL_TEXT
     ,REPORT_TITLE1_TEXT
     ,REPORT_TITLE2_TEXT

     ,GERMPLASM_LIST_DETAILS_TAB
     ,GERMPLASM_LIST_DATA_TAB
     ,STUDY_DETAILS_TEXT
     ,GERMPLASM_DETAILS_TEXT
     ,FACTORS_TEXT
     ,VARIATES_TEXT
     ,EFFECTS_TEXT
     ,DATASETS_TEXT
     ,DB_LOCAL_TEXT
     ,DB_CENTRAL_TEXT

     ,DATE_LABEL
     ,NAME_LABEL
     ,LOCATION_LABEL
     ,TYPEDESC_LABEL
     ,TYPE_LABEL
     ,COUNTRY_LABEL
     ,SEASON_LABEL
 
     ,TITLE_LABEL
     ,OBJECTIVE_LABEL
     ,GID_LABEL
     ,PREFNAME_LABEL
     ,METHOD_LABEL
     ,CREATION_DATE_LABEL
     ,REFERENCE_LABEL
     ,START_DATE_LABEL
     ,END_DATE_LABEL
     ,NO_DATASETS_RETRIEVED_LABEL

     ,STUDY_EFFECT_HEADER
     ,DATASET_TEXT
     ,EFFECT_TEXT
     ,CLICK_DATASET_TO_VIEW_TEXT
     ,DATASET_OF_TEXT
     ,REPRESENTATION_TEXT
     ,FACT_STRING
     ,NAME_HEADER
     ,DESCRIPTION_HEADER
     ,PROPERTY_HEADER
     ,SCALE_HEADER
     ,LOCATION_HEADER
     ,LOT_BALANCE_HEADER
     ,LOT_COMMENT_HEADER
     ,METHOD_HEADER
     ,DATATYPE_HEADER
     ,DATE_HEADER
     ,REFRESH_LABEL
     ,STUDY_DETAILS_LABEL
     ,GERMPLASM_LIST_DETAILS_LABEL
     ,LISTDATA_GID_HEADER
     ,LISTDATA_ENTRY_ID_HEADER
     ,LISTDATA_ENTRY_CODE_HEADER
     ,LISTDATA_SEEDSOURCE_HEADER
     ,LISTDATA_DESIGNATION_HEADER
     ,LISTDATA_GROUPNAME_HEADER
     ,LISTDATA_STATUS_HEADER
     ,NO_LISTDATA_RETRIEVED_LABEL
     ,CHARACTERISTICS_LABEL
     ,NAMES_LABEL
     ,ATTRIBUTES_LABEL
     ,GENERATION_HISTORY_LABEL
     ,PEDIGREE_TREE_LABEL
     ,LISTS_LABEL
     ,CLICK_TO_VIEW_GERMPLASM_DETAILS
     ,CLICK_TO_VIEW_STUDY_DETAILS
     ,SEARCH_FOR_LABEL
     ,SEARCH_LABEL
     ,SEARCH_RESULT_LABEL
     ,CLEAR_LABEL
     ,ADD_CRITERIA_LABEL
     ,DELETE_LABEL
     ,DELETE_ALL_LABEL
     ,YOU_CAN_DELETE_THE_CURRENTLY_SELECTED_CRITERIA_DESC
     ,YOU_CAN_DELETE_ALL_THE_CRITERIA_DESC
     ,STEP1_LABEL
     ,STEP2_LABEL
     ,STEP3_LABEL
     ,STEP4_LABEL
     ,STEP5_LABEL
     ,FINAL_STEP_LABEL
     ,SELECT_A_VALUE_FROM_THE_OPTIONS_BELOW_LABEL
     ,TO_ENTER_A_RANGE_OF_VALUES_FOLLOW_THIS_EXAMPLE_LABEL 
     ,SAVE_GERMPLASM_LIST_BUTTON_LABEL
     ,CLOSE_ALL_GERMPLASM_DETAIL_TAB_LABEL
     ,LIST_NAME_LABEL
     ,SAVE_GERMPLASM_LIST_WINDOW_LABEL 
     ,SAVE_LABEL 
     ,CANCEL_LABEL
     ,GROUP_RELATIVES_LABEL 
     ,MANAGEMENT_NEIGHBORS_LABEL 
     ,INVENTORY_INFORMATION_LABEL 
     ,DERIVATIVE_NEIGHBORHOOD_LABEL  
     ,DESCRIPTION_LABEL
     ,STATUS_LABEL
     ,HIDDEN_LABEL
     ,LOCKED_LABEL
     ,FINAL_LABEL
     ,NUMBER_OF_STEPS_FORWARD_LABEL 
     ,NUMBER_OF_STEPS_BACKWARD_LABEL  
     ,DISPLAY_BUTTON_LABEL
     ,NULL_STUDY_DETAILS
     ,NULL_GERMPLASM_DETAILS
     ,GERMPLASM_STUDY_INFORMATION_LABEL
     ,STUDY_NAME_LABEL
     ,NUMBER_OF_ROWS
     ,EXACT_STUDY_NAME_TEXT

     // ERROR NOTIFICATION MESSAGES
     ,EMPTY_STRING
     ,ERROR_DATABASE
     ,ERROR_INTERNAL 
     ,ERROR_PLEASE_CONTACT_ADMINISTRATOR 
     ,ERROR_CONFIGURATION 
     ,ERROR_IN_CREATING_SEARCH_GERMPLASM_BY_PHENO_TAB 
     ,ERROR_IN_ADDING_GERMPLASM_LIST_NAME_AND_DATA 
     ,ERROR_IN_DISPLAYING_NEW_GERMPLASM_DETAIL_TAB 
     ,ERROR_IN_DISPLAYING_RQUESTED_DETAIL 
     ,ERROR_IN_DISPLAYING_GERMPLASM_DETAIL_TAB 
     ,ERROR_INVALID_INPUT_MUST_BE_NUMERIC
     ,ERROR_INVALID_NUMBER_FORMAT_MUST_BE_NUMERIC 
     ,ERROR_IN_GENERATING_PEDIGREE_TREE 
     ,ERROR_IN_SEARCH 
     ,ERROR_IN_DISPLAYING_DETAILS 
     ,ERROR_IN_DISPLAYING_TRAIT_TABLE 
     ,ERROR_IN_GETTING_FACTORS_OF_REPRESENTATION  
     ,ERROR_IN_GETTING_VARIATES_OF_REPRESENTATION 
     ,ERROR_IN_GETTING_TRAITS
     ,ERROR_IN_SHOWING_FACTOR_DETAILS
     ,ERROR_IN_SHOWING_VARIATE_DETAILS
     ,ERROR_IN_GETTING_STUDY_DETAIL_BY_ID 
     ,ERROR_IN_GETTING_REPRESENTATION_BY_STUDY_ID 
     ,ERROR_IN_GETTING_STUDY_FACTOR 
     ,ERROR_IN_GETTING_GERMPLASM_IDS_BY_PHENO_DATA
     ,ERROR_IN_GETTING_TOP_LEVEL_STUDIES 
     ,ERROR_IN_GETTING_TOP_LEVEL_FOLDERS
     ,ERROR_IN_NUMBER_FORMAT 
     ,ERROR_IN_CREATING_STUDY_INFO_TAB 
     ,ERROR_IN_GETTING_STUDIES_BY_PARENT_FOLDER_ID 
     ,ERROR_IN_GETTING_GERMPLASM_LISTS_BY_PARENT_FOLDER_ID
     ,ERROR_IN_GETTING_STUDY_VARIATE
     ,ERROR_IN_GETTING_VALUES_BY_SCALE_ID 
     ,ERROR_INVALID_FORMAT 
     ,ERROR_INPUT 
     ,ERROR_NO_SELECTED_TRAIT_SCALE_METHOD
     ,ERROR_IN_GETTING_GERMPLASM_DETAILS 
     ,ERROR_WITH_GERMPLASM_SEARCH_RESULT
     ,ERROR_IN_GETTING_GERMPLASM_LIST_BY_ID
     ,ERROR_IN_GETTING_NAMES_BY_GERMPLASM_ID
     ,ERROR_IN_GETTING_ATTRIBUTES_BY_GERMPLASM_ID
     ,ERROR_IN_GETTING_GENERATION_HISTORY
     ,ERROR_IN_GETTING_GERMPLASM_LIST_RESULT_BY_PREFERRED_NAME
     ,ERROR_IN_GETTING_PREFERRED_NAME_BY_GERMPLASM_ID
     ,ERROR_IN_GETTING_REPORT_ON_LOTS_BY_ENTITY_TYPE_AND_ENTITY_ID
     ,ERROR_IN_ADDING_GERMPLASM_LIST
     ,ERROR_IN_COUNTING_TRAITS
     ,ERROR_IN_GETTING_SCALES_BY_TRAIT_ID
     ,ERROR_IN_GETTING_TRAIT_METHOD
     ,ERROR_IN_GETTING_DISCRETE_VALUES_OF_SCALE
     ,ERROR_NULL_TABLE
     ,ERROR_IN_GETTING_DERIVATIVE_NEIGHBORHOOD
     ,ERROR_IN_CREATING_STUDY_DETAILS_WINDOW
     ,ERROR_IN_CREATING_GERMPLASM_DETAILS_WINDOW
     ,ERROR_IN_GERMPLASM_STUDY_INFORMATION_BY_GERMPLASM_ID
     ,ERROR_TEXT
     ,ERROR_INVALID_DIRECTORY
     ,ERROR_INVALID_DESTINATION_FOLDER_TEXT
     ,ERROR_PLEASE_INPUT_FILE_NAME_TEXT

}