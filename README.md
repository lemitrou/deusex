# Deusex Api Test Framework

Run test Instructions:

Easy method:

1. Clone repo in a local folder e.t.c /home/Projects/deusex
2. Open console to root path of the project folder
3. Execute: ./gradlew clean test
4. Check result in file: <RootProjectPath>/build/reports/tests/test/index.html

Not easy method (Intellij specific):

1. open cloned repo with intellij
2. Create a TestNg Run/Debug configuration with the following configuration
3. Test kind: Suite
4. Suite path : <Local folder>/deusex/src/test/resources/suite.xml (The file with the testcases)
5. Output Directory: <Local folder>/deusex/build/reports/tests/test
6. Save it
7. Execute saved run configuration and check the result in <Local folder>/deusex/build/reports/tests/test/index.html file

