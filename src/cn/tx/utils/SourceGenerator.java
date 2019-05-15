package cn.tx.utils;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import javax.sql.rowset.spi.XmlWriter;
import java.io.*;

public class SourceGenerator {
    public static void main(String[] args) throws Exception {

        generator("ProductType");

    }

    public static void generator(String className) throws Exception {
        generQuery(className);
        generDao(className);
        generDaoImpl(className);
        generService(className);
        generServiceImpl(className);
        generDaoConfig(className);
        generServiceConfig(className);
    }

    //生成query
    public static void generQuery(String className) throws Exception {
        //读取模板文件
        BufferedReader br = new BufferedReader(new FileReader("config/cn/tx/template/DemoQuery.tlf"));
        //将生成的query文件写入query包
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/cn/tx/query/"+className+"Query.java"));
        String line = null;
        String line1 = null;
        while((line = br.readLine()) != null){
            line1 = line.replace("Demo",className );
            bw.write(line1);
            bw.newLine();
            bw.flush();
        }
        bw.close();
        br.close();
    }

    //生成dao
    public static void generDao(String className) throws Exception {
        //读取dao模板文件
        BufferedReader br = new BufferedReader(new FileReader("config/cn/tx/template/DemoDao.tlf"));
        //将生成的dao文件写入dao包
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/cn/tx/dao/"+className+"Dao.java"));
        String line = null;
        String line1 = null;
        while((line = br.readLine()) != null){
            line1 = line.replace("Demo",className );
            bw.write(line1);
            bw.newLine();
            bw.flush();
        }
        bw.close();
        br.close();
    }

    //生成daoImpl
    public static void generDaoImpl(String className) throws Exception {
        //读取daoImpl模板文件
        BufferedReader br = new BufferedReader(new FileReader("config/cn/tx/template/DemoDaoImpl.tlf"));
        //将生成的daoImpl文件写入daoImpl包
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/cn/tx/dao/impl/"+className+"DaoImpl.java"));
        String line = null;
        String line1 = null;
        while((line = br.readLine()) != null){
            line1 = line.replace("Demo",className );
            bw.write(line1);
            bw.newLine();
            bw.flush();
        }
        bw.close();
        br.close();
    }


    //生成service
    public static void generService(String className) throws Exception {
        //读取service模板文件
        BufferedReader br = new BufferedReader(new FileReader("config/cn/tx/template/DemoService.tlf"));
        //将生成的service文件写入service包
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/cn/tx/service/"+className+"Service.java"));
        String line = null;
        String line1 = null;
        while((line = br.readLine()) != null){
            line1 = line.replace("Demo",className );
            bw.write(line1);
            bw.newLine();
            bw.flush();
        }
        bw.close();
        br.close();
    }

    //生成serviceImpl
    public static void generServiceImpl(String className) throws Exception {
        //获得首字母小写的类名
        String lowerCaseClassName = className.substring(0,1).toLowerCase() + className.substring(1);
        //读取serviceImpl模板文件
        BufferedReader br = new BufferedReader(new FileReader("config/cn/tx/template/DemoServiceImpl.tlf"));
        //将生成的serviceImpl文件写入serviceImpl包
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/cn/tx/service/impl/"+className+"ServiceImpl.java"));
        String line = null;
        String line1 = null;
        while((line = br.readLine()) != null){
            line1 = line.replace("Demo",className ).replace("demo",lowerCaseClassName );
            bw.write(line1);
            bw.newLine();
            bw.flush();
        }
        bw.close();
        br.close();
    }

    //生成dao的spring配置文件
    public static void generDaoConfig(String className) throws Exception {
        //获得首字母小写的类名
        String lowerCaseClassName = className.substring(0,1).toLowerCase() + className.substring(1);
        SAXReader reader = new SAXReader();
        Document document = reader.read(new FileReader("config/ApplicationContext-dao.xml"));
        Element rootElement = document.getRootElement();

        Element newElement = rootElement.addElement("bean")
                             .addAttribute("id",lowerCaseClassName+"Dao" )
                             .addAttribute("class","cn.tx.dao.impl."+className+"DaoImpl");
        newElement.addElement("property")
                  .addAttribute("name","sessionFactory" )
                  .addAttribute("ref","sessionFactory" );
        XMLWriter xmlWriter = new XMLWriter(new FileWriter("config/ApplicationContext-dao.xml"), OutputFormat.createPrettyPrint());
        xmlWriter.write(document);
        xmlWriter.close();
    }

    //生成service的spring配置文件
    public static void generServiceConfig(String className) throws Exception {
        //获得首字母小写的类名
        String lowerCaseClassName = className.substring(0,1).toLowerCase() + className.substring(1);
        SAXReader reader = new SAXReader();
        Document document = reader.read(new FileReader("config/ApplicationContext-service.xml"));
        Element rootElement = document.getRootElement();

        Element newElement = rootElement.addElement("bean")
                .addAttribute("id",lowerCaseClassName+"Service" )
                .addAttribute("class","cn.tx.service.impl."+className+"ServiceImpl");
        newElement.addElement("property")
                .addAttribute("name",lowerCaseClassName+"Dao" )
                .addAttribute("ref",lowerCaseClassName+"Dao");
        XMLWriter xmlWriter = new XMLWriter(new FileWriter("config/ApplicationContext-service.xml"), OutputFormat.createPrettyPrint());
        xmlWriter.write(document);
        xmlWriter.close();
    }
}
