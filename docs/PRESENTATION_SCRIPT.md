# 🎤 Pockit Official Presentation Script

This is the complete, updated word-for-word presentation script for Group 6's Pockit project presentation. Bolded sections indicate exact code files and technical concepts to highlight on screen.

---

## 👤 Presenter 1: Matt Oyugi (Part 1) – Intro & Overview

### Slide 1: Title (15 sec)
"Good day everyone, we’re Group 6, and our project is **Pockit**, a personal expense and budget tracker for Android. Most people don’t know where their money goes. Pockit lets you record spending, see it in interactive charts, receive budget alerts, and set limits so you stay in control."

### Slide 2: Team Roles (10 sec)
"There are nine of us. You’ll hear from each person, and our names and roles are shown on this slide."

### Slide 3: Overview (15 sec)
"Pockit is built in Kotlin with an MVVM architecture, and it stores everything locally on the phone using a Room SQLite database. That means it works 100% offline, and a user’s data never leaves their device."

### Slide 4: Key Features (15 sec)
"It has seven main features: a home dashboard, an in-app notification center with heads-up system popups, a wallet for multiple accounts, transaction entry with soft keypad, analysis charts, category budgets, and user session isolation. We’ll show you each one live."

### Handoff (5 sec)
"Jeremy will start with the login and navigation flow."

---

## 👤 Presenter 2: Jeremy Adrian – Authentication & Navigation Flow

### Welcome, Register and Login (60 sec)
"When the app opens, you see the Welcome screen with two options: Create Account and Log In. Behind the scenes, our **`nav_graph.xml`** file handles this flow. The app starts at the **`splashFragment`**, which navigates automatically to **`welcomeFragment`**.

**Scenario:** If I tap Create Account, I enter my name, email and password. Tapping Register creates the account and takes me straight to the dashboard. In code, this triggers the **`action_register_to_dashboard`** action. 

Notice the XML attributes **`app:popUpTo="@id/nav_graph"`** and **`app:popUpToInclusive="true"`**. This is a crucial security feature: it clears the entire backstack so that once you are logged in, pressing the physical Back button cannot take you back to registration or login screens."

### Multi-User Isolation (30 sec)
"Each person’s data is completely isolated. When a user logs in, **`Session.userId`** is updated with their email address. Every single SQL query in our DAOs filters by this **`userId`**. If two people share a phone, they never see each other’s financial records."

### Bottom Navigation Bar (45 sec)
"The bar at the bottom has five icons: Home, Summary, Add (+), Budget, and Wallet. All of these destinations are declared in **`nav_graph.xml`**.

In **`MainActivity.kt`**, we connect the bar using **`binding.bottomNav.setupWithNavController(navController)`**. To prevent broken UI, we also added an **`addOnDestinationChangedListener`** that automatically hides the bottom bar on authentication screens (Splash, Welcome, Login, Register) and shows it on main screens."

### Global Logout (20 sec)
"When a user taps Log Out on the dashboard, we trigger the global action **`action_global_logout`**. Using **`popUpToInclusive="true"`**, it wipes the navigation backstack clean and returns to the Welcome screen safely."

### Handoff (5 sec)
"Mwaura will now show you how transactions are recorded."

---

## 👤 Presenter 3: Mwaura F – Expenses, Transfers & Form Keypad

### Opening (15 sec)
"Thanks, Jeremy. I worked on transaction entry in **`AddExpenseFragment.kt`**. It handles three transaction types: Expense, Income, and Transfer."

### Soft Keypad & Multi-Type Form (60 sec)
"Instead of bringing up the system soft keyboard that covers half the screen, we built a custom soft numeric keypad with digits 0-9, a single decimal check, and backspace.

**Scenario (Expense/Income):** I choose an account like M-Pesa, Cash, or Bank, and a category like Food or Transport. I enter the amount and tap **SAVE TRANSACTION** using the full-width horizontal button at the bottom."

### Scenario (Transfer & Dynamic Visibility) (45 sec)
"If I switch to **Transfer**, the Category dropdown disappears and a **'To Account'** dropdown appears, because moving money between accounts has no category.

In **`AddExpenseFragment.kt`**, we observe the selected type. When 'Transfer' is selected, it sets **`layoutCategory.visibility = View.GONE`** and **`layoutToAccount.visibility = View.VISIBLE`**."

### Form Validation (30 sec)
"Before saving, the fragment executes **`RecordInput.validate()`**. It checks that the amount is greater than zero and, for transfers, ensures that the Source and Destination accounts are different. If validation fails, an error message is shown and saving is halted."

### Handoff (5 sec)
"Faith will show how spending is visualized."

---

## 👤 Presenter 4: Faith – Analytics Donut Chart & Budget Progress

### Opening (15 sec)
"Thanks, Mwaura. I worked on the Analysis screen (**`SummaryFragment.kt`**) and the Budgets screen (**`BudgetFragment.kt`**)."

### Custom Donut Chart (50 sec)
"On the Summary screen, we render an interactive donut chart drawn on an Android Canvas using our custom class **`DonutChartView.kt`**. It extends Android's **`View`** class and overrides **`onDraw`**, calculating sweep angles with **`drawArc`** for each percentage share.

We added selector tabs for **Expense**, **Income**, and **Transfer**. Tapping a tab passes the new category list to **`donut.setData(...)`**, which calls **`invalidate()`** to redraw the chart instantly with matching colors, percentages, and legend items."

### Category Budgets & Custom Categories (50 sec)
"On the Budget screen, every expense category has a progress bar showing spent against limit. Color coding gives instant feedback: Purple for normal, Amber for near limit (>80%), and Red for over budget.

**Scenario:** A user can tap any category to edit its limit. They can also tap **'+ ADD BUDGET CATEGORY'** to create custom categories like *Subscriptions* with a monthly limit, which immediately updates the progress bars."

### Handoff (5 sec)
"Mukui will explain the design system behind the app."

---

## 👤 Presenter 5: Mukui Kabura – UI/UX Design, Styling & Dialogs

### Opening (15 sec)
"Thanks, Faith. I designed how Pockit looks, feels, and interacts."

### Color Tokens & Styling (40 sec)
"Our design system is defined in **`colors.xml`**:
- **Cream (`#F8F1DC`)** for warm, low-strain backgrounds.
- **Deep Purple (`#46044B`)** for primary text, headers, and action buttons.
- **Lavender (`#E3D3F2`)** for active indicator highlights."

### High-Contrast Dropdowns & Nav Bar (45 sec)
"We solved two key UI challenges:
1. **Dropdown Contrast:** Android default Spinners rendered dark text on dark dropdown lists. We created **`spinner_item.xml`** and **`spinner_dropdown_item.xml`** with explicit white card backgrounds (`#FFFFFF`) and dark purple text (`#46044B`).
2. **Bottom Bar Highlight:** Material 3 rendered overlapping double active indicators. In **`MainActivity.kt`**, we set **`isItemActiveIndicatorEnabled = false`** and applied a clean custom inset lavender pill background (**`bg_nav_item_selected.xml`**)."

### Custom Success Dialog (30 sec)
"Instead of quick Toast messages that disappear, we created a custom popup dialog (**`SuccessDialog.kt`** & **`dialog_success.xml`**). It displays a checkmark icon, action summary text, an 'X' button in the top right, a Close button, and can be dismissed by tapping outside."

### Handoff (5 sec)
"Matt will explain the architecture and data repository."

---

## 👤 Presenter 6: Matt Oyugi (Part 2) – Architecture & Data Flow

### Architecture & Repository (45 sec)
"Let's look under the hood. Pockit follows Google's recommended MVVM pattern.

**`PockitRepository.kt`** acts as our single source of truth. It is designed as a thread-safe Singleton using **`PockitRepository.get(context)`**. ViewModels never query SQLite directly—they observe cold Kotlin **`Flow`** streams exposed by the repository like **`observeBalances()`** and **`observeRecords()`**. Whenever the database changes, Room automatically emits updated data down the pipeline."

### Data Controls (Reset & Demo Data) (30 sec)
"On the Wallet screen, we added two data control actions:
1. **LOAD DUMMY DATA:** Calls **`forceSeedDemoData()`** in `PockitRepository` to populate sample accounts, transactions, and budgets.
2. **RESET / CLEAR DATA:** Calls **`clearUserData()`** to wipe all user transactions and restore default empty accounts (**M-Pesa**, **Cash**, **Bank**) at KSh 0 balance."

### Handoff (5 sec)
"Joy will explain the database and account storage."

---

## 👤 Presenter 7: Joy Livvy – Database, Accounts & Calculated Balances

### Room Database Setup (50 sec)
"I configured the database layer using Room ORM on SQLite, stored in **`pockit.db`**. You can see this in **`AppDatabase.kt`**. We implemented thread-safe double-checked locking using **`@Volatile`** and **`synchronized`** in **`getInstance()`** to prevent concurrent connection conflicts."

### Default Category Seeding (25 sec)
"We implemented a Room Database Callback called **`SeedCategories`**. The first time **`pockit.db`** is created on a phone, **`onCreate`** executes raw SQL **`INSERT`** statements to pre-populate default Expense and Income categories like *Food*, *Transport*, and *Salary*."

### Dynamic Account Balances (60 sec)
"Key architectural decision: **We do not store account balances as static numbers.** Instead, **`AccountDao.observeBalances`** calculates balances on the fly using SQL:
$$\text{Balance} = \text{Opening Balance} + \text{Income} - \text{Expenses} - \text{Transfers Out} + \text{Transfers In}$$
Why? If a transaction is edited or deleted, a stored balance becomes stale. A calculated balance is always 100% accurate. And because **`observeBalances`** returns a Kotlin **`Flow`**, any transaction edit automatically updates account balances across the app in real time."

### Account Editing (25 sec)
"In **`WalletFragment.kt`**, users can add new accounts, edit an account's name and opening balance via **`AccountDao.updateAccount`**, or delete an account."

### Handoff (5 sec)
"Gracey will explain transaction storage and queries."

---

## 👤 Presenter 8: Gracey Buhere – Records DAO, Aggregations & Validation

### Unified Record Entity (40 sec)
"Every transaction—whether Expense, Income, or Transfer—is stored in one SQLite table via the **`MoneyRecord`** entity. For expenses and income, **`categoryId`** is populated. For transfers, **`toAccountId`** is populated."

### Time-Window Aggregations & Donut Queries (50 sec)
"In **`RecordDao.kt`**, **`observeTotal`** sums transaction amounts between **`:fromTime`** and **`:toTime`** epoch milliseconds.

For donut charts, **`observeTotalsByCategory`** joins records with categories using **`GROUP BY c.id`** and **`ORDER BY total DESC`**. For transfers, **`observeTransferTotals`** joins records with destination accounts (**`toAccountId`**)."

### Input Validation Business Rules (45 sec)
"In **`RecordInput.kt`**, the **`validate()`** function checks business constraints:
- Amount must be finite and $> 0$.
- Expense/Income requires a valid category.
- Transfer requires `toAccountId != accountId` (prevents transferring to the same account).
If invalid, it returns a specific **`RecordError`** enum with user-friendly error messages."

### Handoff (5 sec)
"Reagan will explain notifications, budgets, and reactive flows."

---

## 👤 Presenter 9: Reagan Kutto – Budgets, Notifications & System Popups

### Budget Status JOIN Query (45 sec)
"In **`BudgetDao.kt`**, **`observeStatus`** executes a **`LEFT JOIN`** between categories, budgets, and records. This ensures every expense category appears on screen with its monthly limit and spent amount, even if no budget limit has been set yet."

### Dual-Layer Notifications & System Popups (60 sec)
"We built a dual-layer notification system:
1. **In-App Notification Center (`NotificationsFragment`):** Stores alerts in Room DB (**`AppNotification`** entity) and displays unread badges on the Dashboard bell icon.
2. **System Heads-Up Popups (`NotificationHelper.kt`):** Configures an Android High-Importance channel (**`pockit_popup_alerts_v2`** with **`IMPORTANCE_HIGH`** and vibration pattern) and **`NotificationCompat.PRIORITY_HIGH`**.

**Scenario:** When an expense transaction exceeds a category's monthly budget, **`PockitRepository`** automatically generates an **'⚠️ Over Budget Warning'** that pops up dynamically on top of the phone screen!"

### Handoff (5 sec)
"Roy will wrap up with documentation and system diagrams."

---

## 👤 Presenter 10: Roy Ian Nasser – Documentation Lead & Conclusion

### Codebase Documentation & System Diagrams (60 sec)
"I authored our documentation suite:
- **`README.md`**: Complete tech stack, architecture layer overview, and Gradle build commands (`./gradlew app:assembleDebug`).
- **`docs/SYSTEM_DIAGRAMS.md`**: Mermaid system diagrams including the Room ERD schema, System Architecture, and Notification Data Flow sequence diagrams.
- **`docs/ANDROID_FOR_WEB_DEVS.md`**: Onboarding guide mapping web concepts (React, JSX, Express, SQL) to Android Kotlin equivalents.
- **`docs/PRESENTATION_QA.md`**: Defense Q&A guide preparing the team for technical questions."

### Conclusion & Q&A Open (15 sec)
"That concludes Group 6's presentation for Pockit. The app is fully built, tested, and available as an APK. Thank you for your time, and we are now open to your questions!"
