# Foodlator

An application where you can access nutritional values categorized by food items.

## General Overview
![design](https://github.com/fleaudie/Foodlator/assets/121239335/262e6e0d-79cd-47a8-8bbb-0e3c819ac660)
Figma Link: https://www.figma.com/file/5sKsGT4rRafE9MJRCXclTZ/Foodlator?type=design&t=pUUXkZmJouikAOKj-6

## Technologies
- Kotlin
- OkHttp
- Figma

## Features

### 1. Home Page
I have designed the home page to showcase various food categories that I personally curated. Each of these categories is linked to specific names I have established using the API that I developed.

### 2. Body Mass Index (BMI) Calculator
In order to assist you better in understanding the body mass index, I have designed a straightforward mechanism on the calculation page, which can be conveniently accessed from the main page. By providing the required information, you will be able to compute your own body mass index effortlessly.

### 3. Category Pages

I utilize the category names that are interconnected on the main page to facilitate the transfer of solely the foods and their corresponding nutritional values pertaining to that specific category from the API to this particular page. This is effectively accomplished by employing the RecyclerView and Adapter mechanisms.

### 4. API Integration
In the API integration segment, I skillfully employed the OkHttp library to establish a connection with the Python-developed API. By means of this API, I gain access to the respective page within my application. Please bear in mind that since the API remains inaccessible to the general public, the application is presently confined to devices that are connected to the local network.

## Usage
1. Launch the application on your device.
2. Explore different food categories on the home page.
3. Use the BMI calculator to calculate your Body Mass Index.
4. Click on a category to view detailed information about foods.

## API
The API used in this project is written in Python. You can find the source code and documentation in the `api` directory of this repository.
