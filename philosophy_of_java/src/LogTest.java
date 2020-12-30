
import java.io.IOException;
import java.util.logging.*;

import static java.util.logging.Level.FINER;
import static java.util.logging.Level.WARNING;

public class LogTest {
    public static Logger logger=Logger.getLogger(LogTest.class.getName());
//  static   Handler handler;
    public static void main(String[] args) throws IOException {
        LogManager.getLogManager().readConfiguration();
     Handler  handler=new FileHandler("/Geek Brains/java/philosophy_of_java/src/java.log");
      //  logger.setUseParentHandlers(false);
       // handler.setFormatter(new MyFormatter());
        //handler.setFilter(new MyFilter());
        logger.addHandler(handler);
        logger.fine("dfine");
        logger.info("information");
        System.out.println(System.getProperty("java.util.logging.config.file"));
method();
    }
    static void method(){
        try {
            throw new RuntimeException();
        }catch (RuntimeException e){

            logger.log(WARNING,"ddd",e);
            logger.info("dddd");
        }
    }
   static class MyFormatter extends Formatter {
       @Override
       public String format(LogRecord record) {
           return record.getLevel()+" : "+record.getMessage()+"\n";
       }
   }
   static class MyFilter implements Filter{

       @Override
       public boolean isLoggable(LogRecord record) {
           if(record.getMessage().startsWith("d")) return true;
           return false;
       }
   }
}
