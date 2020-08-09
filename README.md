### Online-Assignment

#### Selected Categories for search are `Restaurants`, `Petrol Stations` and `Shopping Locations`.

#### `Components`
- `Controller: ` DistanceController
- `Services: ` CityService, PetrolStationService, RestaurantService, ShoppingService
- `Models: ` Category, Item, LocationCoardinates, OpeningHours, Result, ResultFromApi
- `Utils: ` Utils

#### `Other Information`
- Test Class: TestDistanceController
- city_coordinates.properties file contains City coardinates.
- while testing please update active apiKey in application.properties file.
- URL : http://localhost:8191/city?city=berlin

#### `Sample output from my system :`
{
    "response": {
        "restaurants": [
            {
                "distance": 715,
                "distanceWithCurrentLoc": 0.007623341327794583,
                "title": "Lindenbrau am Potsdamer Platz",
                "position": [
                    52.510282,
                    13.372547
                ],
                "averageRating": 0,
                "category": {
                    "id": "restaurant",
                    "title": "Restaurant",
                    "href": "https://places.ls.hereapi.com/places/v1/categories/places/restaurant?app_id=tQBEiBa509vz38bHxoRc&app_code=hfwsjSaebKH_mSIZlK6tfw",
                    "type": "urn:nlp-types:category",
                    "system": "places"
                },
                "openingHours": {
                    "text": "Mon-Sun: 11:30 - 01:00",
                    "label": "Opening hours",
                    "isOpen": false
                }
            },
            {
                "distance": 627,
                "distanceWithCurrentLoc": 0.008447070498107594,
                "title": "Il Punto",
                "position": [
                    52.51881,
                    13.38563
                ],
                "averageRating": 0,
                "category": {
                    "id": "restaurant",
                    "title": "Restaurant",
                    "href": "https://places.ls.hereapi.com/places/v1/categories/places/restaurant?app_id=tQBEiBa509vz38bHxoRc&app_code=hfwsjSaebKH_mSIZlK6tfw",
                    "type": "urn:nlp-types:category",
                    "system": "places"
                },
                "openingHours": {
                    "text": "Mon-Wed, Fri, Sat: 12:00 - 23:00<br/>Thu: 12:00 - 12:03",
                    "label": "Opening hours",
                    "isOpen": false
                }
            },
            {
                "distance": 584,
                "distanceWithCurrentLoc": 0.00848113789535138,
                "title": "Einstein Unter den Linden",
                "position": [
                    52.51714,
                    13.38609
                ],
                "averageRating": 0,
                "category": {
                    "id": "restaurant",
                    "title": "Restaurant",
                    "href": "https://places.ls.hereapi.com/places/v1/categories/places/restaurant?app_id=tQBEiBa509vz38bHxoRc&app_code=hfwsjSaebKH_mSIZlK6tfw",
                    "type": "urn:nlp-types:category",
                    "system": "places"
                },
                "openingHours": {
                    "text": "Mon-Sun: 08:00 - 22:00",
                    "label": "Opening hours",
                    "isOpen": true
                }
            }
        ],
        "petrolStations": [
            {
                "distance": 1750,
                "distanceWithCurrentLoc": 0.015756881036555287,
                "title": "TOTAL",
                "position": [
                    52.50017,
                    13.37678
                ],
                "averageRating": 0,
                "category": {
                    "id": "petrol-station",
                    "title": "Petrol Station",
                    "href": "https://places.ls.hereapi.com/places/v1/categories/places/petrol-station?app_id=tQBEiBa509vz38bHxoRc&app_code=hfwsjSaebKH_mSIZlK6tfw",
                    "type": "urn:nlp-types:category",
                    "system": "places"
                },
                "openingHours": {
                    "text": "Mon-Sun: 00:00 - 24:00",
                    "label": "Opening hours",
                    "isOpen": true
                }
            },
            {
                "distance": 1910,
                "distanceWithCurrentLoc": 0.017250568106584714,
                "title": "Total Station",
                "position": [
                    52.53304,
                    13.37965
                ],
                "averageRating": 0,
                "category": {
                    "id": "petrol-station",
                    "title": "Petrol Station",
                    "href": "https://places.ls.hereapi.com/places/v1/categories/places/petrol-station?app_id=tQBEiBa509vz38bHxoRc&app_code=hfwsjSaebKH_mSIZlK6tfw",
                    "type": "urn:nlp-types:category",
                    "system": "places"
                },
                "openingHours": null
            },
            {
                "distance": 2363,
                "distanceWithCurrentLoc": 0.02133995313959274,
                "title": "TOTAL",
                "position": [
                    52.5371,
                    13.37526
                ],
                "averageRating": 0,
                "category": {
                    "id": "petrol-station",
                    "title": "Petrol Station",
                    "href": "https://places.ls.hereapi.com/places/v1/categories/places/petrol-station?app_id=tQBEiBa509vz38bHxoRc&app_code=hfwsjSaebKH_mSIZlK6tfw",
                    "type": "urn:nlp-types:category",
                    "system": "places"
                },
                "openingHours": {
                    "text": "Mon-Sun: 00:00 - 24:00",
                    "label": "Opening hours",
                    "isOpen": true
                }
            }
        ],
        "shoppings": [
            {
                "distance": 612,
                "distanceWithCurrentLoc": 0.005602901034288626,
                "title": "LP12 Mall of Berlin",
                "position": [
                    52.51045,
                    13.379
                ],
                "averageRating": 0,
                "category": {
                    "id": "mall",
                    "title": "Shopping Centre",
                    "href": "https://places.ls.hereapi.com/places/v1/categories/places/mall?app_id=tQBEiBa509vz38bHxoRc&app_code=hfwsjSaebKH_mSIZlK6tfw",
                    "type": "urn:nlp-types:category",
                    "system": "places"
                },
                "openingHours": {
                    "text": "Mon-Sat: 10:00 - 21:00",
                    "label": "Opening hours",
                    "isOpen": false
                }
            },
            {
                "distance": 722,
                "distanceWithCurrentLoc": 0.007471358644851803,
                "title": "Sony Center",
                "position": [
                    52.51006,
                    13.37304
                ],
                "averageRating": 0,
                "category": {
                    "id": "sights-museums",
                    "title": "Sights & Museums",
                    "href": "https://places.ls.hereapi.com/places/v1/categories/places/sights-museums?app_id=tQBEiBa509vz38bHxoRc&app_code=hfwsjSaebKH_mSIZlK6tfw",
                    "type": "urn:nlp-types:category",
                    "system": "places"
                },
                "openingHours": {
                    "text": "Mon-Sun: 00:00 - 24:00",
                    "label": "Opening hours",
                    "isOpen": true
                }
            },
            {
                "distance": 831,
                "distanceWithCurrentLoc": 0.0076949139046512465,
                "title": "Potsdamer Platz Arkaden",
                "position": [
                    52.50856,
                    13.37539
                ],
                "averageRating": 0,
                "category": {
                    "id": "mall",
                    "title": "Shopping Centre",
                    "href": "https://places.ls.hereapi.com/places/v1/categories/places/mall?app_id=tQBEiBa509vz38bHxoRc&app_code=hfwsjSaebKH_mSIZlK6tfw",
                    "type": "urn:nlp-types:category",
                    "system": "places"
                },
                "openingHours": {
                    "text": "Mon-Sat: 10:00 - 21:00",
                    "label": "Opening hours",
                    "isOpen": false
                }
            }
        ],
        "locationCoardinates": {
            "longitude": 52.5159,
            "altitude": 13.3777,
            "cityName": "berlin"
        },
        "message": "Data Received"
    }
}

