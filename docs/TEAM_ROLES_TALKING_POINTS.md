# 👥 Team Roles & Presentation Codebase Guide

This document assigns specific codebase sections, files to present, navigation code explanations, and **4+ technical talking points** for every member of the project team during presentation and defense.

---

## 👑 1. Matt Oyugi (Team Leader) – Intro, Architecture & Nav Host
**Role Overview:** Architecture lead, overall project coordination, repository pattern, multi-user session management, and Shell Activity setup.

### Files to Present & Open in IDE:
- [`PockitRepository.kt`](file:///C:/Users/Matt/Documents/KCA UNIVERSITY DOCS/Bsc.IT docs/Year2Trim2/Mobile_Applications_Development/Project/app/src/main/java/com/group/pockit/data/PockitRepository.kt)
- [`Session.kt`](file:///C:/Users/Matt/Documents/KCA UNIVERSITY DOCS/Bsc.IT docs/Year2Trim2/Mobile_Applications_Development/Project/app/src/main/java/com/group/pockit/data/Session.kt)
- [`MainActivity.kt`](file:///C:/Users/Matt/Documents/KCA UNIVERSITY DOCS/Bsc.IT docs/Year2Trim2/Mobile_Applications_Development/Project/app/src/main/java/com/group/pockit/MainActivity.kt)

### 4 Technical Talking Points:
1. **Architecture & MVVM Pattern:** Established the overall MVVM architecture and Repository pattern where `PockitRepository` acts as the single source of truth between Room SQLite DAOs and UI ViewModels.
2. **NavHost Shell Setup:** Configured `MainActivity.kt` with `NavHostFragment` and `setupWithNavController` linking `BottomNavigationView` dynamically to the navigation graph.
3. **Session Management & User Isolation:** Designed `Session.kt` to dynamically bind `userId` from user logins, ensuring all SQL queries filter per-user data so logins are strictly isolated.
4. **Data Control & Reset Strategy:** Implemented `clearUserData()` and `forceSeedDemoData()` in the repository to support clean data wiping (restoring zero-balance default accounts) and manual dummy data seeding.

---

## 📱 2. Jeremy Adrian – Authentication & Navigation Flow
**Role Overview:** Auth screens (Welcome, Login, Register), Navigation Graph routing, backstack security clearing, and Bottom Navigation routing.

### Files to Present & Open in IDE:
- [`nav_graph.xml`](file:///C:/Users/Matt/Documents/KCA UNIVERSITY DOCS/Bsc.IT docs/Year2Trim2/Mobile_Applications_Development/Project/app/src/main/res/navigation/nav_graph.xml)
- [`LoginFragment.kt`](file:///C:/Users/Matt/Documents/KCA UNIVERSITY DOCS/Bsc.IT docs/Year2Trim2/Mobile_Applications_Development/Project/app/src/main/java/com/group/pockit/ui/auth/LoginFragment.kt)
- [`RegisterFragment.kt`](file:///C:/Users/Matt/Documents/KCA UNIVERSITY DOCS/Bsc.IT docs/Year2Trim2/Mobile_Applications_Development/Project/app/src/main/java/com/group/pockit/ui/auth/RegisterFragment.kt)

### 4 Technical Talking Points:
1. **Navigation Graph Architecture:** Defined all app destinations and navigation paths in `nav_graph.xml`, using `<navigation>` root, `<fragment>` targets, and `<action>` connectors.
2. **Backstack Security Clearing (`popUpTo`):** Configured `app:popUpTo="@id/nav_graph"` and `app:popUpToInclusive="true"` on login and registration actions to clear the backstack so logged-in users cannot press 'Back' to return to auth screens.
3. **Global Logout Action:** Created `action_global_logout` in `nav_graph.xml` to securely end user sessions and reset the backstack straight to the Welcome screen.
4. **Destination Listener:** Configured `addOnDestinationChangedListener` in `MainActivity.kt` to automatically show/hide the bottom navigation bar on authentication vs main feature screens.

---

## 📱 3. Mwaura F – Expenses, Transfers & Keypad Form
**Role Overview:** Add Expense/Income/Transfer form, soft numeric keypad, dynamic To-Account toggles, horizontal save button.

### Files to Present & Open in IDE:
- [`AddExpenseFragment.kt`](file:///C:/Users/Matt/Documents/KCA UNIVERSITY DOCS/Bsc.IT docs/Year2Trim2/Mobile_Applications_Development/Project/app/src/main/java/com/group/pockit/ui/expenses/AddExpenseFragment.kt)
- [`fragment_add_expense.xml`](file:///C:/Users/Matt/Documents/KCA UNIVERSITY DOCS/Bsc.IT docs/Year2Trim2/Mobile_Applications_Development/Project/app/src/main/res/layout/fragment_add_expense.xml)

### 4 Technical Talking Points:
1. **Multi-Type Transaction Form:** Implemented `AddExpenseFragment` handling Expense, Income, and Transfer modes seamlessly.
2. **Custom Soft Keypad Logic:** Developed custom keypad event handling (digits 0-9, single decimal check, backspace) without bringing up system soft keyboard.
3. **Dynamic To-Account Visibility:** Implemented UI switching for Transfer mode: automatically hides Category dropdown and shows "To Account" spinner.
4. **Horizontal Save Action:** Designed full-width horizontal `SAVE TRANSACTION` action button at the bottom of the form for thumb-friendly ergonomics.

---

## 📱 4. Faith – Analytics Donut Chart & Budget Progress
**Role Overview:** Summary/Analysis screen, custom DonutChartView canvas drawing, Expense/Income/Transfer analysis tabs, Budget screen UI.

### Files to Present & Open in IDE:
- [`SummaryFragment.kt`](file:///C:/Users/Matt/Documents/KCA UNIVERSITY DOCS/Bsc.IT docs/Year2Trim2/Mobile_Applications_Development/Project/app/src/main/java/com/group/pockit/ui/dashboard/SummaryFragment.kt)
- [`DonutCHartView.kt`](file:///C:/Users/Matt/Documents/KCA UNIVERSITY DOCS/Bsc.IT docs/Year2Trim2/Mobile_Applications_Development/Project/app/src/main/java/com/group/pockit/ui/dashboard/DonutCHartView.kt)
- [`BudgetFragment.kt`](file:///C:/Users/Matt/Documents/KCA UNIVERSITY DOCS/Bsc.IT docs/Year2Trim2/Mobile_Applications_Development/Project/app/src/main/java/com/group/pockit/ui/budget/BudgetFragment.kt)

### 4 Technical Talking Points:
1. **Custom Canvas Donut Chart:** Implemented `DonutChartView` extending Android `View` and drawing arc slices on Canvas for percentage distributions.
2. **Multi-Type Analysis Tabs:** Integrated Expense, Income, and Transfer selector tabs updating chart data, legends, and list adapters dynamically.
3. **Budget Progress Bars & Color-Coding:** Developed `BudgetAdapter` with progress bars dynamically colored Red (Over limit), Amber (Near limit), or Purple (Normal).
4. **Add Budget Category Dialog:** Built "+ ADD BUDGET CATEGORY" workflow allowing users to create new custom categories with limits.

---

## 🎨 5. Mukui Kabura – UI/UX Design, Styling & Dialogs
**Role Overview:** Design tokens, Pockit color theme palette, custom XML shape drawables, launcher icon, high-contrast Spinners, and SuccessDialog layout.

### Files to Present & Open in IDE:
- [`colors.xml`](file:///C:/Users/Matt/Documents/KCA UNIVERSITY DOCS/Bsc.IT docs/Year2Trim2/Mobile_Applications_Development/Project/app/src/main/res/values/colors.xml)
- [`dialog_success.xml`](file:///C:/Users/Matt/Documents/KCA UNIVERSITY DOCS/Bsc.IT docs/Year2Trim2/Mobile_Applications_Development/Project/app/src/main/res/layout/dialog_success.xml)
- [`SuccessDialog.kt`](file:///C:/Users/Matt/Documents/KCA UNIVERSITY DOCS/Bsc.IT docs/Year2Trim2/Mobile_Applications_Development/Project/app/src/main/java/com/group/pockit/util/SuccessDialog.kt)
- [`spinner_dropdown_item.xml`](file:///C:/Users/Matt/Documents/KCA UNIVERSITY DOCS/Bsc.IT docs/Year2Trim2/Mobile_Applications_Development/Project/app/src/main/res/layout/spinner_dropdown_item.xml)

### 4 Technical Talking Points:
1. **Cohesive Color Palette & Launcher Icon:** Defined centralized design tokens in `colors.xml` featuring Cream (`#F8F1DC`), Deep Purple (`#46044B`), and Lavender (`#E3D3F2`), and designed adaptive launcher icon (`ic_pockit_launcher_bg`).
2. **Custom Success Popup UI:** Designed `dialog_success.xml` featuring white rounded container, checkmark icon, top-right 'X' close button, and dim background overlay.
3. **High-Contrast Spinner Dropdowns:** Solved black-on-black dropdown text issues by creating `spinner_item.xml` and `spinner_dropdown_item.xml` with explicit white backgrounds (`#FFFFFF`) and dark purple text (`#46044B`).
4. **Single Active Nav Bar Indicator:** Resolved dual-background styling in BottomNavigationView by applying custom inset lavender pill background (`bg_nav_item_selected.xml`).

---

## 🛠️ 6. Joy Livvy – Database, Accounts & Balance Queries
**Role Overview:** Room ORM configuration, AppDatabase singleton, Account Entity & DAO, balance editing.

### Files to Present & Open in IDE:
- [`AppDatabase.kt`](file:///C:/Users/Matt/Documents/KCA UNIVERSITY DOCS/Bsc.IT docs/Year2Trim2/Mobile_Applications_Development/Project/app/src/main/java/com/group/pockit/data/AppDatabase.kt)
- [`AccountDao.kt`](file:///C:/Users/Matt/Documents/KCA UNIVERSITY DOCS/Bsc.IT docs/Year2Trim2/Mobile_Applications_Development/Project/app/src/main/java/com/group/pockit/data/dao/AccountDao.kt)
- [`Account.kt`](file:///C:/Users/Matt/Documents/KCA UNIVERSITY DOCS/Bsc.IT docs/Year2Trim2/Mobile_Applications_Development/Project/app/src/main/java/com/group/pockit/data/model/Account.kt)

### 4 Technical Talking Points:
1. **Room Database Singleton:** Built `AppDatabase.kt` using Room's `@Database` annotation and thread-safe double-checked locking singleton pattern.
2. **Database Seeding Callback:** Created the `SeedCategories` callback that automatically populates default Expense and Income categories upon initial SQLite creation.
3. **Dynamic Account Balance Calculation:** Authored the SQL query in `AccountDao.observeBalances` calculating balances dynamically: $\text{Opening Balance} + \text{Income} - \text{Expenses} - \text{Transfers Out} + \text{Transfers In}$.
4. **Account Editing & Operations:** Implemented CRUD queries in `AccountDao` including `insert`, `updateAccount` (editing balance and name), and user-scoped account deletion.

---

## 🛠️ 7. Gracey Buhere – Records DAO, Aggregations & Validation
**Role Overview:** MoneyRecord Entity, Record DAO, SQL aggregations, and transaction input validation rules.

### Files to Present & Open in IDE:
- [`RecordDao.kt`](file:///C:/Users/Matt/Documents/KCA UNIVERSITY DOCS/Bsc.IT docs/Year2Trim2/Mobile_Applications_Development/Project/app/src/main/java/com/group/pockit/data/dao/RecordDao.kt)
- [`MoneyRecord.kt`](file:///C:/Users/Matt/Documents/KCA UNIVERSITY DOCS/Bsc.IT docs/Year2Trim2/Mobile_Applications_Development/Project/app/src/main/java/com/group/pockit/data/model/MoneyRecord.kt)
- [`RecordInput.kt`](file:///C:/Users/Matt/Documents/KCA UNIVERSITY DOCS/Bsc.IT docs/Year2Trim2/Mobile_Applications_Development/Project/app/src/main/java/com/group/pockit/data/model/RecordInput.kt)

### 4 Technical Talking Points:
1. **Unified MoneyRecord Entity:** Designed `MoneyRecord` with support for `RecordType.EXPENSE`, `RecordType.INCOME`, and `RecordType.TRANSFER`.
2. **SQL Time-Window Aggregations:** Authored `observeTotal` query in `RecordDao` computing total income, expense, or transfers across dynamic epoch millisecond ranges.
3. **Category & Transfer Breakdown Queries:** Authored `observeTotalsByCategory` and `observeTransferTotals` using SQL `GROUP BY` and `JOIN` statements to generate slice percentages for the donut chart.
4. **Input Validation Logic:** Created `RecordInput.validate()` to enforce business constraints (e.g. amount > 0, required categories, and ensuring Transfer `fromAccount` and `toAccount` are different).

---

## 🛠️ 8. Reagan Kutto – Budgets, Notifications & Reactive Streams
**Role Overview:** Budget Entity, Budget DAO, AppNotification Entity, NotificationDao, NotificationHelper Heads-Up system alerts, and Kotlin Flow reactive streams.

### Files to Present & Open in IDE:
- [`BudgetDao.kt`](file:///C:/Users/Matt/Documents/KCA UNIVERSITY DOCS/Bsc.IT docs/Year2Trim2/Mobile_Applications_Development/Project/app/src/main/java/com/group/pockit/data/dao/BudgetDao.kt)
- [`NotificationDao.kt`](file:///C:/Users/Matt/Documents/KCA UNIVERSITY DOCS/Bsc.IT docs/Year2Trim2/Mobile_Applications_Development/Project/app/src/main/java/com/group/pockit/data/dao/NotificationDao.kt)
- [`NotificationHelper.kt`](file:///C:/Users/Matt/Documents/KCA UNIVERSITY DOCS/Bsc.IT docs/Year2Trim2/Mobile_Applications_Development/Project/app/src/main/java/com/group/pockit/util/NotificationHelper.kt)
- [`AppNotification.kt`](file:///C:/Users/Matt/Documents/KCA UNIVERSITY DOCS/Bsc.IT docs/Year2Trim2/Mobile_Applications_Development/Project/app/src/main/java/com/group/pockit/data/model/AppNotification.kt)

### 4 Technical Talking Points:
1. **Complex Budget Status JOIN Query:** Developed `BudgetDao.observeStatus` query joining `categories` with `budgets` and subqueries on `records` to produce spent-vs-limit status per category in one query.
2. **System Heads-Up Notifications (`NotificationHelper`):** Configured Android high-priority `NotificationChannel` (`pockit_popup_alerts_v2` with `IMPORTANCE_HIGH` & vibration pattern) that pops up on top of the phone screen during budget overruns or transfers.
3. **In-App Notification DAO & Flow:** Built `AppNotification` entity and `NotificationDao` queries tracking read/unread alerts and unread counts in real-time.
4. **Reactive Kotlin Flow Integration:** Integrated cold `Flow` streams across DAOs so Room automatically emits new data to ViewModels when database rows change.

---

## 📚 9. Roy Ian Nasser – Documentation Lead & Conclusion
**Role Overview:** Codebase documentation, technical specifications, presentation Q&A guide, system ERD diagrams, and web-to-Android guide.

### Files to Present & Open in IDE:
- [`README.md`](file:///C:/Users/Matt/Documents/KCA UNIVERSITY DOCS/Bsc.IT docs/Year2Trim2/Mobile_Applications_Development/Project/README.md)
- [`docs/SYSTEM_DIAGRAMS.md`](file:///C:/Users/Matt/Documents/KCA UNIVERSITY DOCS/Bsc.IT docs/Year2Trim2/Mobile_Applications_Development/Project/docs/SYSTEM_DIAGRAMS.md)
- [`docs/PRESENTATION_QA.md`](file:///C:/Users/Matt/Documents/KCA UNIVERSITY DOCS/Bsc.IT docs/Year2Trim2/Mobile_Applications_Development/Project/docs/PRESENTATION_QA.md)
- [`docs/ANDROID_FOR_WEB_DEVS.md`](file:///C:/Users/Matt/Documents/KCA UNIVERSITY DOCS/Bsc.IT docs/Year2Trim2/Mobile_Applications_Development/Project/docs/ANDROID_FOR_WEB_DEVS.md)

### 4 Technical Talking Points:
1. **Comprehensive Project README:** Authored root `README.md` detailing app features, technology stack table, project structure, and build instructions.
2. **System Architecture & ERD Diagrams:** Created `docs/SYSTEM_DIAGRAMS.md` with interactive Mermaid diagrams for ERD, Architecture, and Notification Data Flow sequence diagrams.
3. **Web-to-Android Onboarding Guide:** Created `docs/ANDROID_FOR_WEB_DEVS.md` mapping web concepts (JSX, React state, Redux, Express, SQL) to Android Kotlin equivalents.
4. **Presentation Defense Q&A Preparation:** Developed `docs/PRESENTATION_QA.md` covering expected technical defense questions, design decisions, and solutions.
