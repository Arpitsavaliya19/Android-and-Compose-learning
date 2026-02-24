package com.arpit.exploreahmedabad.data.dataSource

import com.arpit.exploreahmedabad.R

object AhmedabadDataProvider {
    val place = listOf<Place>(
        Place(
            id = 1,
            imageResourceId = R.drawable.adalaj_stepwell,
            nameResourceId = R.string.historical_adalaj_stepwell,
            locationResourceId = R.string.adalaj_stepwell_location,
            descriptionResourceId = R.string.adalaj_stepwell_desc,
            category = PlaceCategory.HISTORICAL
        ),
        Place(
            id = 2,
            imageResourceId = R.drawable.sabarmati_ashram,
            nameResourceId = R.string.historical_sabarmati_ashram,
            locationResourceId = R.string.sabarmati_ashram_location,
            descriptionResourceId = R.string.sabarmati_ashram_desc,
            category = PlaceCategory.HISTORICAL
        ),
        Place(
            id = 3,
            imageResourceId = R.drawable.teen_darwaza,
            nameResourceId = R.string.historical_teen_darwaza,
            locationResourceId = R.string.teen_darwaza_location,
            descriptionResourceId = R.string.teen_darwaza_desc,
            category = PlaceCategory.HISTORICAL
        ),
        Place(
            id = 4,
            imageResourceId = R.drawable.bhadra_fort,
            nameResourceId = R.string.historical_bhadra_fort,
            locationResourceId = R.string.bhadra_fort_location,
            descriptionResourceId = R.string.bhadra_fort_desc,
            category = PlaceCategory.HISTORICAL
        ),
        Place(
            id = 5,
            imageResourceId = R.drawable.hutheesing_jain_temple,
            nameResourceId = R.string.historical_hutheesing,
            locationResourceId = R.string.hutheesing_jain_temple_location,
            descriptionResourceId = R.string.hutheesing_jain_temple_desc,
            category = PlaceCategory.HISTORICAL
        ),
        Place(
            id = 6,
            imageResourceId = R.drawable.jhulta_minar,
            nameResourceId = R.string.historical_jhulta_minar,
            locationResourceId = R.string.jhulta_minar_location,
            descriptionResourceId = R.string.jhulta_minar_desc,
            category = PlaceCategory.HISTORICAL
        ),
        Place(
            id = 7,
            imageResourceId = R.drawable.sidi_saiyyed_mosque,
            nameResourceId = R.string.historical_sidi_saiyyed,
            locationResourceId = R.string.sidi_saiyyed_mosque_location,
            descriptionResourceId = R.string.sidi_saiyyed_mosque_desc,
            category = PlaceCategory.HISTORICAL
        ),
        Place(
            id = 8,
            imageResourceId = R.drawable.agashiye_restaurant_image,
            nameResourceId = R.string.restaurant_agashiye,
            locationResourceId = R.string.agashiye_location,
            descriptionResourceId = R.string.agashiye_desc,
            category = PlaceCategory.RESTAURANTS
        ),
        Place(
            id = 9,
            imageResourceId = R.drawable.gordhan_restaurants_image,
            nameResourceId = R.string.restaurant_gordhan_thal,
            locationResourceId = R.string.gordhan_thal_location,
            descriptionResourceId = R.string.gordhan_thal_desc,
            category = PlaceCategory.RESTAURANTS
        ),
        Place(
            id = 10,
            imageResourceId = R.drawable.vishala_restaurants_image,
            nameResourceId = R.string.restaurant_vishalla,
            locationResourceId = R.string.vishalla_location,
            descriptionResourceId = R.string.vishalla_desc,
            category = PlaceCategory.RESTAURANTS
        ),
        Place(
            id = 11,
            imageResourceId = R.drawable.undertheneemtree_restaurant_image,
            nameResourceId = R.string.under_the_neem_name,
            locationResourceId = R.string.under_the_neem_location,
            descriptionResourceId = R.string.under_the_neem_desc,
            category = PlaceCategory.RESTAURANTS
        ),
        Place(
            id = 12,
            imageResourceId = R.drawable.sarkhej_roza,
            nameResourceId = R.string.historical_sarkhej_roza,
            locationResourceId = R.string.sarkhej_roza_location,
            descriptionResourceId = R.string.sarkhej_roza_desc,
            category = PlaceCategory.HISTORICAL
        ),
        Place(
            id = 13,
            imageResourceId = R.drawable.swati_snacks_restaurant,
            nameResourceId = R.string.swati_snacks_name,
            locationResourceId = R.string.swati_snacks_location,
            descriptionResourceId = R.string.swati_snacks_desc,
            category = PlaceCategory.RESTAURANTS
        ),
        Place(
            id = 14,
            imageResourceId = R.drawable.manek_choke_restaurant,
            nameResourceId = R.string.historical_manek_chowk,
            locationResourceId = R.string.manek_chowk_market_location,
            descriptionResourceId = R.string.manek_chowk_market_desc,
            category = PlaceCategory.RESTAURANTS
        ),
        Place(
            id = 15,
            imageResourceId = R.drawable.law_garden_markt,
            nameResourceId = R.string.law_garden_market_name,
            locationResourceId = R.string.law_garden_location,
            descriptionResourceId = R.string.law_garden_market_desc,
            category = PlaceCategory.SHOPPING
        ),
        Place(
            id = 16,
            imageResourceId = R.drawable.manek_chowk_shopping,
            nameResourceId = R.string.shopping_manek_chowk,
            locationResourceId = R.string.manek_chowk_market_location,
            descriptionResourceId = R.string.manek_chowk_market_desc,
            category = PlaceCategory.SHOPPING
        ),
        Place(
            id = 17,
            imageResourceId = R.drawable.dhalgarwad_market,
            nameResourceId = R.string.shopping_dhalgarwad,
            locationResourceId = R.string.dhalgarwad_market_location,
            descriptionResourceId = R.string.dhalgarwad_market_desc,
            category = PlaceCategory.SHOPPING
        ),
        Place(
            id = 18,
            imageResourceId = R.drawable.sindhi_market_ahmedabad,
            nameResourceId = R.string.shopping_sindhi_market,
            locationResourceId = R.string.sindhi_market_location,
            descriptionResourceId = R.string.sindhi_market_desc,
            category = PlaceCategory.SHOPPING
        ),
        Place(
            id = 19,
            imageResourceId = R.drawable.ravivari_market_ahmedabad,
            nameResourceId = R.string.shopping_ravivari,
            locationResourceId = R.string.sindhi_market_location,
            descriptionResourceId = R.string.ravivari_market_desc,
            category = PlaceCategory.SHOPPING
        ),
        Place(
            id = 20,
            imageResourceId = R.drawable.lal_darwaja_shopping,
            nameResourceId = R.string.lal_darwaja_market_name,
            locationResourceId = R.string.lal_darwaja_market_location,
            descriptionResourceId = R.string.lal_darwaja_market_desc,
            category = PlaceCategory.SHOPPING
        ),
        Place(
            id = 21,
            imageResourceId = R.drawable.kankriya_lake,
            nameResourceId = R.string.kankaria_lake_name,
            locationResourceId = R.string.kankaria_lake_location,
            descriptionResourceId = R.string.kankaria_lake_desc,
            category = PlaceCategory.PARKS
        ),
        Place(
            id = 22,
            imageResourceId = R.drawable.victoria_garden,
            nameResourceId = R.string.victoria_garden_name,
            locationResourceId = R.string.victoria_garden_location,
            descriptionResourceId = R.string.victoria_garden_desc,
            category = PlaceCategory.PARKS
        ),
        Place(
            id = 23,
            imageResourceId = R.drawable.river_front,
            nameResourceId = R.string.riverfront_park_name,
            locationResourceId = R.string.riverfront_park_location,
            descriptionResourceId = R.string.riverfront_park_desc,
            category = PlaceCategory.PARKS
        ),
        Place(
            id = 24,
            imageResourceId = R.drawable.vastrapur_lake_garden,
            nameResourceId = R.string.vastrapur_lake_garden_name,
            locationResourceId = R.string.vastrapur_lake_garden_location,
            descriptionResourceId = R.string.vastrapur_lake_garden_desc,
            category = PlaceCategory.PARKS
        ),
        Place(
            id = 25,
            imageResourceId = R.drawable.law_garden,
            nameResourceId = R.string.law_garden_name,
            locationResourceId = R.string.law_garden_location,
            descriptionResourceId = R.string.law_garden_desc,
            category = PlaceCategory.PARKS
        ),
        Place(
            id = 26,
            imageResourceId = R.drawable.parimal_garden_park,
            nameResourceId = R.string.parimal_garden_name,
            locationResourceId = R.string.parimal_garden_location,
            descriptionResourceId = R.string.parimal_garden_desc,
            category = PlaceCategory.PARKS
        ),
        Place(
            id = 27,
            imageResourceId = R.drawable.palladium_ahmedabad_mall,
            nameResourceId = R.string.shopping_palladium,
            locationResourceId = R.string.palladium_mall_location,
            descriptionResourceId = R.string.palladium_mall_desc,
            category = PlaceCategory.SHOPPING
        ),
    )
}