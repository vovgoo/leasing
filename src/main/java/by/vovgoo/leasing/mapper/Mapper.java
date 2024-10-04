package by.vovgoo.leasing.mapper;

public interface Mapper <K, V> {

    K mapTo(V object);

    V mapFrom(K object);
}
