package model;

import javafx.scene.image.Image;
import model.datasources.Dr7Gz;

/**
 * Created by gram on 29/03/16.
 */
public class DataImage {
    private Image image;
    private Dr7Gz data;

    public DataImage(Image image, Dr7Gz data) {
        this.image = image;
        this.data = data;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Dr7Gz getData() {
        return data;
    }

    public void setData(Dr7Gz data) {
        this.data = data;
    }
}
