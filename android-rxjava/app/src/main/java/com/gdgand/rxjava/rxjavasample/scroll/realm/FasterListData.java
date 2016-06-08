package com.gdgand.rxjava.rxjavasample.scroll.realm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FasterListData extends RealmObject {

    private long position;

}
