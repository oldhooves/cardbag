package com.sunda.passbook.mapper;

import com.spring4all.spring.boot.starter.hbase.api.RowMapper;
import com.sunda.passbook.constant.Constants;
import com.sunda.passbook.vo.Feedback;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;

/**
 * Created by 老蹄子 on 2018/8/17 下午4:11
 */
public class FeedbackRowMapper implements RowMapper<Feedback> {

    private static byte[] FAMILY_I = Constants.Feedback.FAMILY_I.getBytes();
    private static byte[] USER_ID = Constants.Feedback.USER_ID.getBytes();
    private static byte[] TYPE = Constants.Feedback.TYPE.getBytes();
    private static byte[] TEMPLATE_ID = Constants.Feedback.TEMPLATE_ID.getBytes();
    private static byte[] COMMENT = Constants.Feedback.COMMENT.getBytes();

    @Override
    public Feedback mapRow(Result result, int i) throws Exception {
        Feedback feedback = new Feedback();
        feedback.setUserId(Bytes.toLong(result.getValue(FAMILY_I, USER_ID)));
        feedback.setType(Bytes.toString(result.getValue(FAMILY_I, TYPE)));
        feedback.setTemplateId(Bytes.toString(result.getValue(FAMILY_I, TEMPLATE_ID)));
        feedback.setComment(Bytes.toString(result.getValue(FAMILY_I, COMMENT)));

        return feedback;
    }
}
