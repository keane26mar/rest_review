package restaurant_project;

public class Rest {
    protected int restId;
    protected String image;
    protected String description;
    protected String address;
    protected int contact;
    protected String website;
    protected String title;
    protected String category;

    public Rest(int restId, String image, String description, String address, int contact, String website, String title, String category) {
        super();
        this.restId = restId;
        this.image = image;
        this.description = description;
        this.address = address;
        this.contact = contact;
        this.website = website;
        this.title = title;
        this.category = category;
    }

    public void setRestId() {
        this.restId = restId;
    }
    public void setImage() {
        this.image = image;
    }
    public void setDescription() {
        this.description = description;
    }
    public void setAddress() {
        this.address = address;
    }
    public void setContact() {
        this.contact = contact;
    }
    public void setWebsite() {
        this.website = website;
    }
    public void setTitle() {
        this.title = title;
    }
    public void setCategory() {
        this.category = category;
    }
    public int getRestId() {
        return restId;
    }
    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public String getAddress() {
        return address;
    }

    public int getContact() {
        return contact;
    }

    public String getWebsite() {
        return website;
    }

    public String getTitle() {
        return title;
    }
    public String getCategory() {
        return category;
    }

}
