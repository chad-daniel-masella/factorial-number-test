# factorial-number-calculator

### 1. Understanding And Breaking Down The Requirements
- [Test Case Document](https://docs.google.com/spreadsheets/d/12sk8CUymApmYFolbInL3abaqfvohkz5ouCLCKanV7Tk/edit?usp=sharing)

### 2. Setting Up The _Playwright_ Project

- Follow the [installation doc for Playwright using Java (maven)](https://playwright.dev/java/docs/intro)
    - Helpful read as well [Installing Maven](https://mkyong.com/maven/install-maven-on-mac-osx/)

### 3. Running The Tests

- Clone this repository and complete the setup documentation here as guidance **_Setting Up The _Playwright_ Project_**
- Tests can be found under the `src/main/java/tests/..` for execution as per the [Running Tests](https://playwright.dev/java/docs/running-tests) documentation on the playwright.dev website.

### 4. Checklist:

1. Write a locator (CSS selector/XPath) for the red form validation styling
2. Find the console message printed
3. Write a Selenium script to test that the factorial of 7 is 5040
4. Figure out the API call being made along with the headers and parameters sent
5. Write a bug report
6. Document a test case
7. Include test coverage
8. Add any documentation that might be necessary to explain your process, include this in a file in the repo.

QA Requirements for you to implement | #1 | #2 | #3 | #4 | #5 | #6 | #7 | #8 
--- |----| --- | --- |--- |--- |--- |--- |---
Notes | See test class `TestInvalidInputRedFormValidation()` | See test class `TestInvalidInputRedFormValidationAndGetConsoleLogs()` | See test class `TestFactorialOfSeven()` | See test class `TestGetFactorialPositiveAPI()` | [Test Case Document](https://docs.google.com/spreadsheets/d/12sk8CUymApmYFolbInL3abaqfvohkz5ouCLCKanV7Tk/edit?usp=sharing) | [Test Case Document](https://docs.google.com/spreadsheets/d/12sk8CUymApmYFolbInL3abaqfvohkz5ouCLCKanV7Tk/edit?usp=sharing) | [Test Case Document](https://docs.google.com/spreadsheets/d/12sk8CUymApmYFolbInL3abaqfvohkz5ouCLCKanV7Tk/edit?usp=sharing) | [Test Case Document](https://docs.google.com/spreadsheets/d/12sk8CUymApmYFolbInL3abaqfvohkz5ouCLCKanV7Tk/edit?usp=sharing)
Implemented | Yes | Yes | Yes | Yes | Yes | Yes | Yes | Yes 

### 5. Postman/Newman Test:

- Please see attached a postman request API that can be used to run in CI/CD Jenkins using newman
- Given you have newman installed as per the [installation doc](https://learning.postman.com/docs/collections/using-newman-cli/installing-running-newman/)
- To run the Postman API:
  - Import the `health-force.postman_collection.json` collection into postman and manually execute from there
  - Execute in cli using newman command `newman run health-force.postman_collection.json`

## Notes:

- For this project I made use of [intelliJ](https://www.jetbrains.com/idea/download/#section=mac)
- I made use of macOS - but to get setup should be quite similar on Windows or Linux OS
- Java Version:
```
openjdk version "20.0.1" 2023-04-18
OpenJDK Runtime Environment (build 20.0.1+9-29)
OpenJDK 64-Bit Server VM (build 20.0.1+9-29, mixed mode, sharing)
```

## Next Steps:

- Input the tests into a CI/CD CRON job on Jenkins to allow for nightly tests to run
- Expand on more test scenarios -> jot down scenarios in testrail or another test management tool