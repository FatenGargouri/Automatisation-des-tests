*** Settings ***
Documentation    Simple Robot Framework Script
Library          SeleniumLibrary

*** Variables ***
${BROWSER1}       chrome
${BROWSER2}       firefox
${URL_Google}    http://www.google.com


*** Test Cases ***
Recherche Google
    Open NavigatorChrome
    Click Element    xpath=//*[@id="APjFqb"]
    #Page Should Contain Element    /html/body/div[1]/div[2]/div/img
    Input Text    //*[@id="APjFqb"]    robot Framework

*** Keywords ***
Open NavigatorChrome
    Open Browser    ${URL_Google}    browser=${BROWSER1}
    Maximize Browser Window
