package online.zhaopei.myproject.service.ecssent;

import java.io.Serializable;
import java.util.List;

import online.zhaopei.myproject.domain.ecssent.InvtHeadStatistics;

public interface InvtHeadStatisticsService extends Serializable {

	List<InvtHeadStatistics> statisticsInvtHeadQuantity(InvtHeadStatistics invtHeadStatistics);
}
