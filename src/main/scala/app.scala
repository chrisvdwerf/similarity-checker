import org.apache.spark.{SparkConf, SparkContext}

object app {

    val FILE_PATH = "src/main/resources/sentences.txt"
    val MASTER = "local"
    val APP_NAME = "similarity checker"
    val SHINGLE_SIZE = 3

    def create_spark_context(): SparkContext = {
        val conf = new SparkConf()
        conf.setMaster(MASTER)
        conf.setAppName(APP_NAME)
        return new SparkContext(conf)
    }

    def main(args: Array[String]): Unit = {
        val sc = create_spark_context()
        val textFile = sc.textFile(FILE_PATH)
        val shingles = textFile.map(line => line.sliding(SHINGLE_SIZE))
        shingles.foreach(shingles_line => shingles_line.foreach(println))
    }
}