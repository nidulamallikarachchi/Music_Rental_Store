
# Musical Instrument Rental Store App

## Overview
This project is an Android application for a Musical Instrument Rental Store. The app allows users to browse, rent, and manage musical instruments. It's built as part of an assignment for the **Software Development for Mobile Devices (COS30017)** course at Swinburne University of Technology. The app provides features such as category filtering, rental management, and credit handling. While it's a prototype, the functionality mimics a real-world rental service.

## Features
- **Instrument Selection**: Browse musical instruments available for rent.
- **Instrument Details**: View detailed information about each instrument, including stock, rental credit, and rating.
- **Category Filtering**: Filter instruments by category using dynamic ChipGroups.
- **Real-time Renting**: Rent instruments instantly, with credit deduction (simulated).
- **Manage Rented Items**: View rented instruments and track the quantity.
- **Store Credit Management**: Add more credit if needed (simulated).

## Technologies Used
- **Kotlin** for Android development.
- **Android Studio** for the development environment.
- **Material Design** components for UI.
- **Git** for version control.

## Installation
1. Clone the repository from GitHub:
   ```bash
   git clone https://github.com/SoftDevMobDev-2024-Classrooms/assignment02-nidulamallikarachchi
   ```
2. Open the project in **Android Studio**.
3. Build and run the application on an emulator or physical Android device.

## App Structure
- **MainActivity.kt**: The main entry point of the app. Handles the toolbar, instrument grid, and category filtering.
- **Instrument.kt**: The data model for instruments.
- **InstrumentAdapter.kt**: Handles the binding of instrument data to the grid view.
- **InstrumentDetailActivity.kt**: Displays detailed information for a selected instrument and manages the rental process.
- **RentedItemsActivity.kt**: Displays the list of instruments currently rented by the user.
- **MyCreditActivity.kt**: Manages user credit and allows purchasing more (simulated).
- **XML Layout Files**: Define the UI structure, including `grid_item.xml`, `activity_instrument_detail.xml`, and `activity_rented_items.xml`.

## User Stories
- **Filter Instruments by Category**: Users can filter instruments to find what they need quickly.
- **Manage Rented Items**: Users can view and manage their rented items in a single place.

## Running the App
1. On launch, users see a grid of musical instruments.
2. Users can filter instruments by category using ChipGroups.
3. Clicking on an instrument shows its details.
4. Users can rent an instrument by confirming the rental, which deducts credits (simulated).
5. The "Rented Items" and "My Credit" sections allow users to view their rentals and manage their credit.

## Challenge Task
Implemented dynamic category filtering using ChipGroups. The app's filtering logic updates as new instruments are added, ensuring flexibility for future store expansions.

## Themes
The app uses a minimalist custom theme, leveraging Android's **Day Night Theme** to apply UI elements selectively.

## Landscape Mode
The app is responsive and performs well in landscape mode, preserving its state between orientations.

## GitHub Repository
For more details and to view the source code, visit the [GitHub repository](https://github.com/SoftDevMobDev-2024-Classrooms/assignment02-nidulamallikarachchi).

## Credits
Developed by **Mallika Arachchillage Nidula Sanketh Mallikarachchi**  
Swinburne ID: 104756611  
Course: Software Development for Mobile Devices (COS30017)

## References
- [Material Design](https://m2.material.io/components)
- [Android App Development in Kotlin](https://www.youtube.com/watch?v=7pcKH0cQE6Y)
