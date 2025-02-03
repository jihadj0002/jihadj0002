@echo off
:: Set the base directory (replace with the root path of your file tree)
set "baseDir=D:\Code\Java\Final\Project\V-01"

:: Deleting .class files in the root folder
if exist "%baseDir%\Start.class" (
    echo Deleting %baseDir%\Start.class
    del "%baseDir%\Start.class"
)

:: Loop through subdirectories and delete .class files
:: controllers folder
if exist "%baseDir%\controllers" (
    for %%f in (AdminController CustomerController EmployeeController FileIO FlightController PaymentController ReservationController UserController) do (
        if exist "%baseDir%\controllers\%%f.class" (
            echo Deleting %baseDir%\controllers\%%f.class
            del "%baseDir%\controllers\%%f.class"
        )
    )
)

:: models folder 
if exist "%baseDir%\models" (
    for %%f in (Admin Customer Employee Flight Payment Reservation User) do (
        if exist "%baseDir%\models\%%f.class" (
            echo Deleting %baseDir%\models\%%f.class
            del "%baseDir%\models\%%f.class"
        )
    )
)


:: Views folder
if exist "%baseDir%\views" (
    for %%f in (FlightOperationFrame AdminOperationFrame AllFlightFrame AllPaymentFrame AllReservationFrame CustomerOperationFrame EmployeeOperationFrame LoginFrame UserOperationFrame) do (
        if exist "%baseDir%\views\%%f.class" (
            echo Deleting %baseDir%\views\%%f.class
            del "%baseDir%\views\%%f.class"
        )
    )
)
:: Views folder
if exist "%baseDir%\views" (
    for %%f in (AdminHomeFrame EmployeeHomeFrame SignUpFrame ForgetPassFrame PaymentOperationFrame ReservationOperationFrame AdminUpdateProfileFrame CustomerHomeFrame CustomerProfileFrame SearchFlightsFrame ViewReservedFlightFrame SearchResultsFrame PaymentHistoryFrame) do (
        if exist "%baseDir%\views\%%f.class" (
            echo Deleting %baseDir%\views\%%f.class
            del "%baseDir%\views\%%f.class"
        )
    )
)


:: Views folder
if exist "%baseDir%\views" (
    for %%f in (BookFlightFrame PaymentFrame CusUpdateProfileFrame) do (
        if exist "%baseDir%\views\%%f.class" (
            echo Deleting %baseDir%\views\%%f.class
            del "%baseDir%\views\%%f.class"
        )
    )
)


:: Compile Start.java
echo Compiling Start.java...
cd "%baseDir%"
::javac Start.java

:: Check if compilation succeeded
if exist "%baseDir%\Start.class" (
    echo Compilation successful. Running Start.java...
    java Start
) else (
    echo Compilation failed. Please check for errors in Start.java.
)

:: Finish
pause