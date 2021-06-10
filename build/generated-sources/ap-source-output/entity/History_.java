package entity;

import entity.Item;
import entity.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-10T15:35:39")
@StaticMetamodel(History.class)
public class History_ { 

    public static volatile SingularAttribute<History, Item> item;
    public static volatile SingularAttribute<History, Long> id;
    public static volatile SingularAttribute<History, User> user;

}