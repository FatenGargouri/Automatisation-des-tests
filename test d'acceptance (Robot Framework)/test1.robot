*** Settings ***
Documentation    Tester le site web automation step by step
Library          SeleniumLibrary

*** Variables ***
${BROWSER}       chrome
${URL}           https://automationstepbystep.com/
${Timeout}       10s
${URL_TRAINING}  https://automationstepbystep.com/trainings-2/

*** Test Cases ***
Access to the site 
    Open Site
Access to the page Training    
    Go To   ${URL_TRAINING}
    Page Should Contain Element    id="tablepress-2
    

*** Keywords ***
Open Site
    Open Browser    ${URL}    ${BROWSER}
    Maximize Browser Window 
    Sleep    ${Timeout}
    Title Should Be    NEVER STOP LEARNING - Automation Step by Step

