# Stock Trading Platform

A desktop stock trading simulator built with **Java Swing** and **SQLite**. Prices change automatically, users buy and sell shares with virtual cash, and an admin manages users and stocks. All data is stored in a local SQLite database.

Created as a Java programming task for CodeAlpha.

## Features

**Market simulation**
- Stock prices move randomly by up to 2% every 3 seconds while the application is running
- A price never falls below 1.00
- The market table on the Buy screen refreshes every 3 seconds

**User**
- Log in with a user name and password
- Buy shares at the current market price (requires enough cash and enough available shares)
- Sell shares from holdings and receive cash at the current price
- View own holdings and own transaction history
- Dashboard with cash balance, number of holdings, number of transactions, **Total Bought**, **Total Sold** and **Profit**

**Admin**
- Same login screen, with the admin role selected by the `isAdmin` flag
- Add and update users (user name, password, cash balance)
- Add and update stocks (name, available quantity, price)
- View all holdings and all transactions
- Dashboard with totals for users, stocks, holdings and transactions

## How Trading Works

- **Buy:** total = quantity × current price. The total is deducted from the user's cash, the stock's available quantity decreases, the holding is created or increased, and a BUY transaction is saved.
- **Sell:** the user receives quantity × current price. The holding decreases, the shares return to the market, and a SELL transaction is saved.
- **Average buy price:** when buying more of a stock already owned, the new average is (old cost + new cost) ÷ total shares. Selling does not change it.
- **Profit** = Total Sold + current value of shares still owned − Total Bought.
- Transactions cannot be edited or deleted from the application.
- Stocks are never removed. The admin "Delete" button sets a stock's available quantity to 0.

## Technologies

- Java 17
- Swing (NetBeans GUI Builder)
- SQLite with the `sqlite-jdbc` driver (included in `lib/`)
- NetBeans (Ant project)

## Project Structure

```
StockTradingPlatform/
├── lib/                          # sqlite-jdbc driver
├── stocktrading.db               # SQLite database file
└── src/stocktradingplatform/
    ├── StockTradingPlatform.java # entry point: starts the price simulator and opens the login screen
    ├── models/                   # User, Stock, Holding, Transaction, TransactionType
    ├── db/                       # DataBase connection, DaoService, UserDao, StockDao, HoldingDao, TransactionDao
    ├── services/                 # MarketSimulator (random price changes)
    └── views/
        ├── LoginView, UserDashboard, AdminDashboard
        ├── user/                 # BuyStockView, SellHoldingView, HoldingViewUser, TransactionViewUser
        └── admin/                # UserView, StockViewAdmin, HoldingViewAdmin, TransactionViewAdmin
```

## Database

| Table | Purpose | Main columns |
|-------|---------|--------------|
| `users` | Accounts | id, userName (unique), password, cashBalance, isAdmin |
| `stocks` | Market | id, companyName (unique), quantity (available shares), currentPrice |
| `holdings` | Shares owned | id, userId, stockId, quantity, averageBuyPrice (one row per user per stock) |
| `transactions` | Trade history | id, userId, stockId, type (BUY / SELL), quantity, unitPrice, totalPrice, createdAt |

The database file `stocktrading.db` is included in the repository with sample data.

## How to Run

1. Clone the repository:
   ```
   git clone https://github.com/MMRSheikh2001/CodeAlpha_Stock_Trading_Platform.git
   ```
2. Open the `StockTradingPlatform` folder as a project in NetBeans (JDK 17 or later).
3. Run the project (F6). The main class is `stocktradingplatform.StockTradingPlatform`.
4. Log in with the demo admin account, `admin` / `1234`, or with any user the admin has created.

The application must be started from the project folder so that it finds `stocktrading.db`. NetBeans does this by default.

## Usage

1. Log in as admin and add a few users with a starting cash balance, and add stocks if needed.
2. Log in as a user and open **Buy**, select a stock, enter a quantity and confirm.
3. Open **Sell** to sell part or all of a holding.
4. Watch Total Bought, Total Sold and Profit on the dashboard change as prices move.

## Limitations

- Passwords are stored as plain text, and the demo admin password is shown on the login screen.
- Prices change only while the application is running.
- Table creation and the first admin and stocks are not created automatically. The database file in the repository already contains them.
- Data is local to one SQLite file, so there is no network or multi-machine use.
- Each user has one cash balance and trades at market price only. There are no limit orders.

## Author

MD Mahbubur Rahman Sheikh — [@MMRSheikh2001](https://github.com/MMRSheikh2001)
