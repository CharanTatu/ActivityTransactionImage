

package com.example.android.activityscenetransitionbasic.model;

public class Item {
       private static final String THUMB_BASE_URL = "https://storage.googleapis.com/androiddevelopers/sample_data/activity_transition/thumbs/";
//    private static final String THUMB_BASE_URL = "http://localhost:8080/getall";
    private static final String POTO_CHARAN = "https://storage.googleapis.com/androiddevelopers/sample_data/";
//    private static final String POTO_CHARAN = "https://storage.googleapis.com/androiddevelopers/sample_data/activity_transition/large/";
//    private static final String THUMB_BASE_URL = "https://storage.googleapis.com/androiddevelopers/sample_data/activity_transition/thumbs/";

    public static Item[] ITEMS = new Item[] {
            new Item("Mobile Team Light", "Mobile team", "flying_in_the_light.jpg"),
            new Item("Caterpillar", "Nyn ", "caterpillar.jpg"),
            new Item("Mobile Dev", "Mobile Guy", "flamingo.jpg"),
            new Item("TVS", "Romain Guy", "rainbow.jpg"),
            new Item("Over there", "Vishal ", "over_there.jpg"),
            new Item("Jelly Fish 2", "Romain ", "jelly_fish_2.jpg"),
            new Item("Lone Pine Sunset", "Sachin ", "lone_pine_sunset.jpg"),
            new Item("Sumasoft image","Charan","look_me_in_the_eye.jpg"),

    };

    public static Item getItem(int id) {
        for (Item item : ITEMS) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    private final String mName;
    private final String mAuthor;
    private final String mFileName;

    Item (String name, String author, String fileName) {
        mName = name;
        mAuthor = author;
        mFileName = fileName;
    }

    public int getId() {
        return mName.hashCode() + mFileName.hashCode();
    }

    public String getAuthor() {
        return mAuthor;
    }

    public String getName() {
        return mName;
    }

    public String getPhotoUrl() {
        return POTO_CHARAN + mFileName;
    }

    public String getThumbnailUrl() {
        return THUMB_BASE_URL + mFileName;
    }

}
