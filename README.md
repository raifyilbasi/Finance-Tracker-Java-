# Finance Tracker (Java) 💰

A command-line based personal finance management tool. This application allows users to track their monthly incomes and expenses, visualize their balance, and manage recurring transactions effortlessly.

## Key Features

- **Monthly Data Segregation:** Automatically creates a new CSV storage file for each month (e.g., `FinanceData2024-05.csv`).
- **Standing Orders (Daueraufträge):** Intelligent logic that automatically detects standing orders from the previous month and carries them over to the current month upon startup.
- **Transaction Management:** - Add income and expenses.
  - View full transaction history with formatted output.
  - Delete specific transactions with automatic file updates.
- **Real-time Balance:** Calculates the current financial status based on all recorded entries.
- **CSV Persistence:** Uses a lightweight CSV format to ensure your data is saved and can be opened in Excel or Google Sheets.

## Project Structure

- `Main.java`: The interactive CLI menu and user interface.
- `FinanceManager.java`: The core logic for calculating balances and managing the transaction list.
- `FilesManager.java`: Handles all File I/O operations, including CSV parsing and monthly file generation.
- `Transaction.java`: The data model representing a single financial entry.

# Environment Requirements
- Runtime: Java Runtime Environment (JRE) 8+
- Compiler: Java Development Kit (JDK) 8+ (Tested with OpenJDK)
- Standard Libraries used: 
    - java.nio.file (Path/Files)
    - java.time (LocalDate/YearMonth)
    - java.util (Scanner/ArrayList/List)