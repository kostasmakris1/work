tasklist /v /fi "Imagename eq chromedriver.exe*" 2>NUL | find /I /N "chromedriver.exe">NUL
if "%ERRORLEVEL%"=="0" taskkill /F /T /IM chromedriver.exe*
tasklist /v /fi "Imagename eq chrome.exe*" 2>NUL | find /I /N "chrome.exe">NUL
if "%ERRORLEVEL%"=="0" taskkill /F /T /IM chrome.exe*
if "%ERRORLEVEL%"=="0" echo "Process Killed"
exit 0