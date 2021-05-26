package ru.job4j.stream;

public class Laptop {
    private String company;
    private String model;
    private String motherBoard;
    private String processor;
    private int ramGB;
    private String graphics;
    private boolean ssd;
    private boolean hdd;
    private String os;
    private double screenDiagonal;
    private double price;

    static class Builder {
        private String company;
        private String model;
        private String motherBoard;
        private String processor;
        private int ramGB;
        private String graphics;
        private boolean ssd;
        private boolean hdd;
        private String os;
        private double screenDiagonal;
        private double price;

        Builder buildCompany(String company) {
            this.company = company;
            return this;
        }

        Builder buildModel(String model) {
            this.model = model;
            return this;
        }

        Builder buildMotherBoard(String motherBoard) {
            this.motherBoard = motherBoard;
            return this;
        }

        Builder buildProcessor(String processor) {
            this.processor = processor;
            return this;
        }

        Builder buildRamGB(int ramGB) {
            this.ramGB = ramGB;
            return this;
        }

        Builder buildGraphics(String graphics) {
            this.graphics = graphics;
            return this;
        }

        Builder buildSSD(boolean ssd) {
            this.ssd = ssd;
            return this;
        }

        Builder buildHDD(boolean hdd) {
            this.hdd = hdd;
            return this;
        }

        Builder buildOS(String os) {
            this.os = os;
            return this;
        }

        Builder buildScreenDiagonal(double screenDiagonal) {
            this.screenDiagonal = screenDiagonal;
            return this;
        }

        Builder buildPrice(double price) {
            this.price = price;
            return this;
        }

        Laptop build() {
            Laptop laptop = new Laptop();
            laptop.company = company;
            laptop.model = model;
            laptop.motherBoard = motherBoard;
            laptop.processor = processor;
            laptop.ramGB = ramGB;
            laptop.graphics = graphics;
            laptop.ssd = ssd;
            laptop.hdd = hdd;
            laptop.os = os;
            laptop.screenDiagonal = screenDiagonal;
            laptop.price = price;
            return laptop;
        }
    }

    @Override
    public String toString() {
        return "Laptop{" + "company='" + company + '\''
                + ", model='" + model + '\''
                + ", motherBoard='" + motherBoard + '\'' + ", processor='"
                + processor + '\'' + ", ramGB=" + ramGB + ", graphics='"
                + graphics + '\'' + ", ssd=" + ssd + ", hdd="
                + hdd + ", os='" + os + '\''
                + ", screenDiagonal=" + screenDiagonal
                + ", price=" + price + '}';
    }

    public static void main(String[] args) {
        Laptop laptop = new Builder()
                .buildCompany("Razer")
                .buildModel("Blade 15 Base Model")
                .buildMotherBoard("Asus")
                .buildProcessor("i7-10750H 6 Core (2.6GHz/5.0GHz)")
                .buildRamGB(16)
                .buildGraphics("NVIDIA® GeForce GTX 1660 Ti")
                .buildSSD(true)
                .buildOS("Windows 10 Home")
                .buildScreenDiagonal(15.6)
                .buildPrice(1299.99)
                .build();
        System.out.println(laptop);
    }
}