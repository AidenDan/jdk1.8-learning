package com.path;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Aiden
 * @version 1.0
 * @description
 * @date 2021-3-28 19:35:04
 */
public class PathTest {
    public static void main(String[] args) {
        Path path = Paths.get("G:\\javaproject\\jdk1.8-learning\\src\\main\\java\\com");
        System.err.println("path:::" + path.toString());
        Path path1 = path.resolve("thread");
        System.err.println("path1:::" + path1.toString());

        // 查询到的文件路径
        List<String> javaFiles = getJavaFiles(path1);

        File zipFile = null;
        FileOutputStream fos = null;
        ZipOutputStream zos = null;
        try {
            // 压缩包名
            LocalDateTime currentTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
            String dateString = formatter.format(currentTime);
            zipFile = new File(path1 + dateString + ".zip");
            zipFile.createNewFile();
            fos = new FileOutputStream(zipFile);
            zos = new ZipOutputStream(fos);
            zos.setEncoding("GBK"); // 防止压缩包里文件名乱码

            String line = null;
            for (String javaFile : javaFiles) {
                String extName = javaFile.substring(javaFile.lastIndexOf("\\"));
                String fileName = "java\\"+extName;
                ZipEntry zipEntry = new ZipEntry(fileName);
                zos.putNextEntry(zipEntry);

                // io流去读文件内容
                BufferedReader bufferedReader = new BufferedReader(new FileReader(javaFile));
                while ((line = bufferedReader.readLine()) != null){
                    zos.write(line.getBytes(StandardCharsets.UTF_8));
                    // 写入换行符
                    zos.write("\r\n".getBytes(StandardCharsets.UTF_8));
                }
            }

            // 文件01，在文件夹01里
//            String file01Name = "文件夹01\\文件01.txt";
//            ZipEntry zipEntry1 = new ZipEntry(file01Name);
//            zos.putNextEntry(zipEntry1);
//            String content1 = "文件内容1111";
//            zos.write(content1.getBytes(StandardCharsets.UTF_8));
//
//            // 文件02，在根目录下
//            String file02Name = "文件02.txt";
//            ZipEntry zipEntry2 = new ZipEntry(file02Name);
//            zos.putNextEntry(zipEntry2);
//            String content2 = "文件内容2222";
//            zos.write(content2.getBytes("UTF-8"));

            zos.flush();
            zos.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static List<String> getJavaFiles(Path path) {
        List<String> list = new ArrayList<>();
        try {
            Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
                /**
                 * Invoked for a directory before entries in the directory are visited.
                 *
                 * <p> Unless overridden, this method returns {@link FileVisitResult#CONTINUE
                 * CONTINUE}.
                 *
                 * @param dir
                 * @param attrs
                 */
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    return super.preVisitDirectory(dir, attrs);
                }

                /**
                 * Invoked for a file in a directory.
                 *
                 * <p> Unless overridden, this method returns {@link FileVisitResult#CONTINUE
                 * CONTINUE}.
                 *
                 * @param file
                 * @param attrs
                 */
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    // 访问path1目录及子目录下的所有文件
                    if (file.toString().endsWith(".java")) {
                        list.add(file.toString());
                    }
                    return FileVisitResult.CONTINUE;
                }

                /**
                 * Invoked for a file that could not be visited.
                 *
                 * <p> Unless overridden, this method re-throws the I/O exception that prevented
                 * the file from being visited.
                 *
                 * @param file
                 * @param exc
                 */
                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    return super.visitFileFailed(file, exc);
                }

                /**
                 * Invoked for a directory after entries in the directory, and all of their
                 * descendants, have been visited.
                 *
                 * <p> Unless overridden, this method returns {@link FileVisitResult#CONTINUE
                 * CONTINUE} if the directory iteration completes without an I/O exception;
                 * otherwise this method re-throws the I/O exception that caused the iteration
                 * of the directory to terminate prematurely.
                 *
                 * @param dir
                 * @param exc
                 */
                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    return super.postVisitDirectory(dir, exc);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
