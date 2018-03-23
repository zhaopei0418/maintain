package online.zhaopei.myproject.service.ecssent;

import online.zhaopei.myproject.domain.ecssent.Store;

import java.util.List;

/**
 * Created by zhaopei on 18/3/23.
 */
public interface StoreService {

    List<Store> getStoreList(Store store);
}
