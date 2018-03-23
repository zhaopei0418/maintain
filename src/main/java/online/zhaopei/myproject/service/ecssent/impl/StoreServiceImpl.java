package online.zhaopei.myproject.service.ecssent.impl;

import online.zhaopei.myproject.domain.ecssent.Store;
import online.zhaopei.myproject.mapper.ecssent.StoreMapper;
import online.zhaopei.myproject.service.ecssent.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhaopei on 18/3/23.
 */
@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreMapper storeMapper;

    @Override
    public List<Store> getStoreList(Store store) {
        return this.storeMapper.getStoreList(store);
    }
}
