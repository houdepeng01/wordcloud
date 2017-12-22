import com.kennycason.kumo.CollisionMode;
import com.kennycason.kumo.Word;
import com.kennycason.kumo.WordCloud;
import com.kennycason.kumo.WordFrequency;
import com.kennycason.kumo.bg.PixelBoundryBackground;
import com.kennycason.kumo.font.scale.LinearFontScalar;
import com.kennycason.kumo.nlp.FrequencyAnalyzer;
import com.kennycason.kumo.palette.ColorPalette;


import java.awt.*;
import java.io.IOException;
import java.util.List;

/**
 * Created by dell on 2017/12/21.
 */
public class main {
    public static void main(String[] args) throws IOException {
        final FrequencyAnalyzer frequencyAnalyzer = new FrequencyAnalyzer();
        frequencyAnalyzer.setWordFrequenciesToReturn(300);
        frequencyAnalyzer.setMinWordLength(4);
//        frequencyAnalyzer.setStopWords(loadStopWords());

        final List<WordFrequency> wordFrequencies = frequencyAnalyzer.load("F:\\git\\kumo\\main\\src\\main\\test.txt");
        final Dimension dimension = new Dimension(500, 312);
        final WordCloud wordCloud = new WordCloud(dimension, CollisionMode.PIXEL_PERFECT);
        wordCloud.setPadding(2);
        wordCloud.setBackground(new PixelBoundryBackground("F:\\git\\kumo\\main\\src\\main\\alice.png"));
        wordCloud.setColorPalette(new ColorPalette(new Color(0x4055F1), new Color(0x408DF1), new Color(0x40AAF1), new Color(0x40C5F1), new Color(0x40D3F1), new Color(0xFFFFFF)));
        wordCloud.setFontScalar(new LinearFontScalar(10, 40));
        /*
        输出单词词频
         */
        wordFrequencies.forEach(System.out::println);
        /*
        输出单词长和宽，坐标。显示你可以截取出长和宽看看怎么显示好？
         */
        List<Word> words = wordCloud.build(wordFrequencies);
        words.forEach(System.out::println);
        wordCloud.writeToFile("F:\\git\\kumo\\main\\src\\main\\alice.png");
    }
}
