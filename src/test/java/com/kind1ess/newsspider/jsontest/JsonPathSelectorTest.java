package com.kind1ess.newsspider.jsontest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import us.codecraft.webmagic.selector.JsonPathSelector;

import java.util.Iterator;
import java.util.List;

@SpringBootTest
public class JsonPathSelectorTest {


    @Test
    void testJson(){
        String json = "{\n" +
                "    \"result\": {\n" +
                "        \"status\": {\n" +
                "            \"code\": \"0\"\n" +
                "        },\n" +
                "        \"encoding\": \"utf-8\",\n" +
                "        \"serverSeconds\": \"1586953661\",\n" +
                "        \"total\": \"34285\",\n" +
                "        \"count\": \"5\",\n" +
                "        \"last_time\": \"1586950473\",\n" +
                "        \"data\": [\n" +
                "            {\n" +
                "                \"id\": \"ircuyvh7986875\",\n" +
                "                \"column\": \"\",\n" +
                "                \"title\": \"特朗普宣布停止资助世卫，克宫回应\",\n" +
                "                \"url\": \"https://news.sina.com.cn/w/2020-04-15/doc-iircuyvh7986875.shtml\",\n" +
                "                \"keywords\": \"特朗普,佩斯科夫,新冠肺炎\",\n" +
                "                \"comment_channel\": \"gj\",\n" +
                "                \"img\": \"//n.sinaimg.cn/spider2020415/669/w864h605/20200415/ffce-isehnnk7752648.jpg\",\n" +
                "                \"level\": \"2\",\n" +
                "                \"createtime\": \"1586952960\",\n" +
                "                \"ext3\": \"\",\n" +
                "                \"ext2\": \"gj:comos-ircuyvh7986875:0\",\n" +
                "                \"ext1\": \"\",\n" +
                "                \"ext4\": \"gj:comos-ircuyvh7986875:0\",\n" +
                "                \"ext5\": \"原标题：特朗普宣布停止资助世卫，克宫回应[环球网报道 记者 王博雅琪]针对美国总统特朗普14日宣布暂停资助世卫组织一事，据俄塔社报道，克里姆林宫发言人佩斯科夫15日回应说，和其他二十国集团（G20）领导人一样，俄…\",\n" +
                "                \"old_level\": \"2\",\n" +
                "                \"media_type\": \"\",\n" +
                "                \"media_name\": \"环球网\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": \"irczymi6515109\",\n" +
                "                \"column\": \"\",\n" +
                "                \"title\": \"肯尼亚新增新冠肺炎确诊病例9例 累计确诊225例\",\n" +
                "                \"url\": \"https://news.sina.com.cn/w/2020-04-15/doc-iirczymi6515109.shtml\",\n" +
                "                \"keywords\": \"新冠肺炎\",\n" +
                "                \"comment_channel\": \"gj\",\n" +
                "                \"img\": \"//n.sinaimg.cn/spider2020415/383/w640h543/20200415/2497-isehnnk7716929.jpg\",\n" +
                "                \"level\": \"2\",\n" +
                "                \"createtime\": \"1586952540\",\n" +
                "                \"ext3\": \"\",\n" +
                "                \"ext2\": \"gj:comos-irczymi6515109:0\",\n" +
                "                \"ext1\": \"\",\n" +
                "                \"ext4\": \"gj:comos-irczymi6515109:0\",\n" +
                "                \"ext5\": \"原标题：肯尼亚新增新冠肺炎确诊病例9例 累计确诊225例肯尼亚卫生部于当地4月15日下午发布消息称，在过去24小时内检测了803人次，新增9例新冠肺炎确诊病例，死亡病例1例和治愈病例12例。目前肯尼亚累计确诊病例225例…\",\n" +
                "                \"old_level\": \"2\",\n" +
                "                \"media_type\": \"\",\n" +
                "                \"media_name\": \"央视\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": \"irczymi6514511\",\n" +
                "                \"column\": \"\",\n" +
                "                \"title\": \"印度新冠肺炎确诊病例升至11933例\",\n" +
                "                \"url\": \"https://news.sina.com.cn/w/2020-04-15/doc-iirczymi6514511.shtml\",\n" +
                "                \"keywords\": \"新冠肺炎\",\n" +
                "                \"comment_channel\": \"gj\",\n" +
                "                \"img\": \"//n.sinaimg.cn/default/feedbackpics/transform/116/w550h366/20180517/q7Vh-harvfhu4569176.png\",\n" +
                "                \"level\": \"2\",\n" +
                "                \"createtime\": \"1586952180\",\n" +
                "                \"ext3\": \"\",\n" +
                "                \"ext2\": \"gj:comos-irczymi6514511:0\",\n" +
                "                \"ext1\": \"\",\n" +
                "                \"ext4\": \"gj:comos-irczymi6514511:0\",\n" +
                "                \"ext5\": \"原标题：印度新冠肺炎确诊病例升至11933例印度卫生部官网最新数据显示，截至当地时间15日下午5点（北京时间17：30），印度共报告新冠肺炎确诊病例11933例，其中治愈出院1344例，死亡392例。数据显示，过去24小时内印…\",\n" +
                "                \"old_level\": \"2\",\n" +
                "                \"media_type\": \"\",\n" +
                "                \"media_name\": \"央视\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": \"irczymi6513425\",\n" +
                "                \"column\": \"\",\n" +
                "                \"title\": \"荷兰新增734例新冠肺炎确诊病例 累计28153例\",\n" +
                "                \"url\": \"https://news.sina.com.cn/w/2020-04-15/doc-iirczymi6513425.shtml\",\n" +
                "                \"keywords\": \"荷兰,新冠肺炎\",\n" +
                "                \"comment_channel\": \"gj\",\n" +
                "                \"img\": \"//n.sinaimg.cn/spider2020415/700/w400h300/20200415/7f39-isehnnk6132704.jpg\",\n" +
                "                \"level\": \"2\",\n" +
                "                \"createtime\": \"1586951520\",\n" +
                "                \"ext3\": \"\",\n" +
                "                \"ext2\": \"gj:comos-irczymi6513425:0\",\n" +
                "                \"ext1\": \"\",\n" +
                "                \"ext4\": \"gj:comos-irczymi6513425:0\",\n" +
                "                \"ext5\": \"原标题：荷兰新增734例新冠肺炎确诊病例 累计28153例[海外网4月15日|战疫全时区]据荷兰卫生部官网15日最新数据，过去24小时，该国新增734例新冠肺炎确诊病例，累计确诊28153例；死亡病例新增189例，累计3134例。…\",\n" +
                "                \"old_level\": \"2\",\n" +
                "                \"media_type\": \"\",\n" +
                "                \"media_name\": \"海外网\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"id\": \"irczymi6512100\",\n" +
                "                \"column\": \"\",\n" +
                "                \"title\": \"新京报：断供世卫，甩锅掩盖不了“美国优先”的失败\",\n" +
                "                \"url\": \"https://news.sina.com.cn/w/2020-04-15/doc-iirczymi6512100.shtml\",\n" +
                "                \"keywords\": \"特朗普,世卫组织,新冠肺炎,美国\",\n" +
                "                \"comment_channel\": \"gj\",\n" +
                "                \"img\": \"//n.sinaimg.cn/news/crawl/160/w550h410/20200415/4c42-isehnnk7641958.jpg\",\n" +
                "                \"level\": \"2\",\n" +
                "                \"createtime\": \"1586950473\",\n" +
                "                \"ext3\": \"\",\n" +
                "                \"ext2\": \"gj:comos-irczymi6512100:0\",\n" +
                "                \"ext1\": \"\",\n" +
                "                \"ext4\": \"gj:comos-irczymi6512100:0\",\n" +
                "                \"ext5\": \"原标题：断供世卫，甩锅掩盖不了“美国优先”的失败当地时间4月14日，特朗普正式宣布，美国暂停向世界卫生组织缴纳会费。不仅如此，他还叫嚣要对该组织进行审查、追责。近些天，特朗普一直在各种场合攻击世卫组织及谭…\",\n" +
                "                \"old_level\": \"2\",\n" +
                "                \"media_type\": \"\",\n" +
                "                \"media_name\": \"北京日报\"\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "}\n";
        JsonPathSelector jsonPathSelector = new JsonPathSelector("$.result.data[*].url");
        String select = jsonPathSelector.select(json);
        List<String> list = jsonPathSelector.selectList(json);
        if (list.size()>0){
            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()){
                System.out.println(iterator.next());
            }
        }
    }
}
