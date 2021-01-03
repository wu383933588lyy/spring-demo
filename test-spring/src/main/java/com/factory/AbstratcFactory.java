package com.factory;

/**
 * @Author WuRui
 * @ClassName AbstratcFactory
 * @Date 2021/1/1 17:06
 * @Version 1.0
 * @Description //TODO
 **/
public class AbstratcFactory {

    interface Pad{
        void run();
    }

    interface Phone {
        void run();
    }

    class Redmi implements Phone {
        @Override
        public void run() {
            System.out.println("Redmi");
        }
    }

    class Apple implements Phone {
        @Override
        public void run() {
            System.out.println("apple");
        }
    }



    class XiaomiPad implements Pad {
        @Override
        public void run() {
            System.out.println("xiaomi pad");
        }
    }

    class IPad implements Pad {
        @Override
        public void run() {
            System.out.println("apple ipad");
        }
    }

    interface PhoneFactory {
        // 手机生产线
        Phone createPhone();
    }

    interface PadFactory {
        // 平板生产线
        Pad createPad();
    }

    interface Factory extends PhoneFactory, PadFactory {
    }

    class AppleFactory implements Factory {
        @Override
        public Phone createPhone() {
            return new Apple();
        }

        @Override
        public Pad createPad() {
            return new IPad();
        }
    }

    class XiaomiFactory implements Factory {
        @Override
        public Redmi createPhone() {
            return new Redmi();
        }

        @Override
        public Pad createPad() {
            return new XiaomiPad();
        }
    }


}
