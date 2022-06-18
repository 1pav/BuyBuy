package it.unitn.disi.buybuy.utils;

import it.unitn.disi.buybuy.dao.entities.Retailer;
import java.util.Comparator;
import it.unitn.disi.buybuy.types.ItemRetailerPair;

public class ItemRetailerComparator implements Comparator<ItemRetailerPair> {

    private Float latitude, longitude;

    public ItemRetailerComparator(float lat, float lng) {
        latitude = lat;
        longitude = lng;
    }

    private ItemRetailerComparator() {
    }

    @Override
    public int compare(ItemRetailerPair o1, ItemRetailerPair o2) {
        Retailer r1 = o1.getValue();
        Retailer r2 = o2.getValue();
        Float distance1 = distance(latitude, longitude, r1.getLatitude(), r1.getLongitude());
        Float distance2 = distance(latitude, longitude, r2.getLatitude(), r2.getLongitude());
        return (int) Math.signum(distance1 - distance2);
    }

    private Float distance(Float lat1, Float lon1, Float lat2, Float lon2) {
        final int R = 6371; // Radius of the earth
        Float latDistance = toRad(lat2 - lat1);
        Float lonDistance = toRad(lon2 - lon1);
        Float a = (float) (Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(toRad(lat1)) * Math.cos(toRad(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2));
        Float c = (float) (2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a)));

        return R * c;
    }

    private static Float toRad(Float value) {
        return (float) (value * Math.PI / 180);
    }

}
