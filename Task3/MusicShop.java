package com.goit.gojava.module3.Task3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class MusicShop {
    private Guitar guitar;
    private Piano piano;
    private Tube tube;
    private List<MusicalInstruments> inStock = new ArrayList<>();

    public List<MusicalInstruments> getInStock() {
        return inStock;
    }

    public void setInStock(MusicalInstruments m) {
        inStock.add(m);
    }


    public Guitar getGuitar() {
        return guitar;
    }

    public void setGuitar(Guitar guitar) {
        this.guitar = guitar;
    }

    public Piano getPiano() {
        return piano;
    }

    public void setPiano(Piano piano) {
        this.piano = piano;
    }

    public Tube getTube() {
        return tube;
    }

    public void setTube(Tube tube) {
        this.tube = tube;
    }
    /*Добавить в магазин инструментов метод, который готовит к отгрузке партию музыкальных инструментов согласно заказу.

Сигнатура метода:
public List<Instrument> prepareInstruments(Map<String, Integer> order){...}

В заказе (Map<String, Integer> order) хранится название инструмента и количество необходимых инструментов.

Ключем в заказе является одна из строк "piano", "guitar", "trumpet"

Создать свое исключение, которое будет брошено в случае, когда ключ в заказе другой.

+Каким-то образом (самостоятельно выбрать решение) обработать ситуацию, когда количество элементов в заказе отрицательное, нулевое.

+После выполнения метода из магазина должны пропасть те инструменты, которые были отгружены.
+В случае, когда количество запрашиваемых инструментов определенного типа больше, чем количество доступных инструментов в магазине,
+должно быть брошено исключение. Выбрать наиболее подходящее из доступных в стандартной библиотеке исключений
Пример:

+ в магазине было 2 фортепиано, 16 гитар и 7 труб.
+пришел заказ на 7 гитар и 2 трубы.
+после выполнения заказа в магазине осталось 2 фортепиано, 9 гитар и 5 труб
+пришел заказ на 1 фортепиано
+после выполнения заказа в магазине осталось 1 фортепиано, 9 гитар и 5 труб
+пришел заказ на 1 фортепиано, 8 гитар и 6 труб
товар не был отгружен (было брошено исключение)
в магазине осталось 1 фортепиано, 9 гитар и 5 труб
 */
    public List<MusicalInstruments> prepareInstruments(Map<String, Integer> order) throws InstrumentNotFoundException, IndexOutOfBoundsException{

        List<String> instrumentsName = new ArrayList<>();
        for (MusicalInstruments m:inStock){
            instrumentsName.add(m.getName());
        }

        for (Map.Entry<String, Integer> iterator: order.entrySet()){
            if (instrumentsName.contains(iterator.getKey())){//checking if instrument is in the stock
              for (MusicalInstruments instrument:inStock) {

                    if (iterator.getKey().equals(instrument.getName())) { //checking for equal instrument in the shop
                        if (iterator.getValue() > 0) {//checking if amount of ordered instruments is >0

                            if (instrument.getAmount() >= iterator.getValue()) { // checking if amount of instrument is enough
                                instrument.setAmount(instrument.getAmount() - iterator.getValue());
                            } else { //if amount of instrument is not enough
                                System.out.println("[error]: no such amount of " + instrument.getName() + "s in the shop");
                                throw new IndexOutOfBoundsException();
                            }
                        }

                    }
              }
            }
            else{//if instrument not in the stock
                throw new InstrumentNotFoundException();
            }
        }

        return inStock;
    }


}
