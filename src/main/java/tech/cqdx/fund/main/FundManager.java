package tech.cqdx.fund.main;

import tech.cqdx.fund.tools.FileUtils;

/**
 * 统计经理人的热度
 * <p>
 * 输入：包含经理人名称的文件，一行一个名称
 * 输出：经理人及对应的重复次数
 */
public class FundManager {
    public static void main(String[] args) {
        FileUtils.readFileByLines("file/fundmanager");
    }
}
