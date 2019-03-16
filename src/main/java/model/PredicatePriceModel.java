package model;

import org.apache.commons.io.IOUtils;
import org.tensorflow.Graph;
import org.tensorflow.Session;
import org.tensorflow.Tensor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.FloatBuffer;
import java.util.List;

public class PredicatePriceModel {

    public static String PB_FILE_PATH = "test_model.pb";
    public static String INPUT_TENSOR_NAME = "lstm_1_input";
    public static String OUTPUT_TENSOR_NAME = "dense_1/BiasAdd";
    public static Integer dim_1 = 74;
    public static Integer dim_2 = 1;
    public static Integer dim_3 = 1;

    /**
     * 输入任意维度d 的城市历史房价信息，得到d个下一个月的预测房价，这里只返回最后一个预测数据
     * @author fsd
     * @param historyPrice
     * @return
     */
    public Float predicateByTime(float[] historyPrice){
        //输入数据的维度
        dim_1 = historyPrice.length;
        //获取模型文件
        float score = 0;
        String filepath = System.getProperty("user.dir")+"/src/main/resources/model/predict_model.pb";
        PB_FILE_PATH = filepath;

        try (Graph graph = new Graph()) {
            //导入图
            byte[] graphBytes = IOUtils.toByteArray(new FileInputStream(PB_FILE_PATH));
            graph.importGraphDef(graphBytes);
            //计算输入数据的向量长度
            Double len = 0.0;
            for(Float item : historyPrice){
                len += Math.pow(item,2);
            }
            len = Math.sqrt(len);
            float[] normHistoryPrice = new float[historyPrice.length];
            for(int i =0 ; i < historyPrice.length; i++){
                 normHistoryPrice[i] = (float) (historyPrice[i] / len);
            }
            long[] shape = new long[]{dim_1,dim_2,dim_3};

            Tensor data = Tensor.create(shape, FloatBuffer.wrap(normHistoryPrice));

            //根据图建立Session
            try (Session session = new Session(graph)) {
                //相当于TensorFlow Python中的sess.run(z, feed_dict = {'x': 10.0})
                //Tensor<?> out = session.runner()
                //.feed(INPUT_TENSOR_NAME, data)
                //.fetch(OUTPUT_TENSOR_NAME).run().get(0);

                List<Tensor<?>> temp = session.runner()
                        .feed(INPUT_TENSOR_NAME, data)
                        .fetch(OUTPUT_TENSOR_NAME)
                        .run();

                Tensor<?> out = temp.get(0);
                // Tensor结果转换
                float[][] t = new float[dim_1][dim_3];
                out.copyTo(t);
                float max = 0f;
                float[] result = t[dim_1-1];
                score = result[0] * len.floatValue();
                System.out.println(score);
//                int label = 0;
//                for (int i = 0; i < result.length; i++) {
//                    score = result[i] * len.floatValue();
//                    System.out.println(score*len);
//                    if (score > max) {
//                        max = score;
//                        label = i;
//                    }
//                }
//                System.out.println(label);
            }

        } catch (FileNotFoundException e) {
            System.out.println("未找到模型文件");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            return score;
        }

    }


    public static void main(String[] args) {
        PredicatePriceModel model = new PredicatePriceModel();
        float[] data = new float[74];
        for(int i = 0; i < 74; i++){
            data[i] = (float) (i * 7.65);
            System.out.println(data[i]);
        }

        System.out.println(model.predicateByTime(data));
    }


}
