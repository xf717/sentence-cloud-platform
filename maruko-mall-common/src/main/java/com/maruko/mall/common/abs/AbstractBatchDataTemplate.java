package com.maruko.mall.common.abs;

import java.util.ArrayList;
import java.util.List;

/**
 * 批量处理数据模版
 * @author xiaofeng
 * @date 20190430 14:30
 */
public abstract class AbstractBatchDataTemplate<T> {

	/**
	 *
	 * @param recordList 数据列表
	 * @param maxValue 最大值
	 * @return
	 * @throws Exception
	 */
	public Integer batchData(List<T> recordList, int maxValue) throws Exception {
		int bathchSize = recordList.size();
		int total = bathchSize / maxValue;
		List<T> list = new ArrayList<>();
		if (bathchSize % maxValue != 0) {
			total += 1;
		}
		Integer batchTotal = 0;

		for (int i = 0; i < total; i++) {
			if (i == total - 1) {
				maxValue = bathchSize - (i * maxValue);
			}
			for (int j = 0; j < maxValue; j++) {
				list.add(recordList.get(j));
			}
			// 批量处理的方法
			Integer count = this.batchHandler(list);
			recordList.removeAll(list);
			list.clear();
			batchTotal += count;
		}
		return batchTotal;
	}

	/**
	 * 批量处理业务
	 *
	 * @param objects
	 * @return
	 */
	public abstract Integer batchHandler(Object... objects);
}
