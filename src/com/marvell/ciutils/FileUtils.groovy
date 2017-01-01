package com.marvell.ciutils

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.attribute.BasicFileAttributes

class FileUtils{

    def deleteIfExists(filePath){
        File file = new File(filePath)
        return Files.deleteIfExists(file.toPath())
    }

   def printInfo(){
        Path dir = Paths.get('resources') 
        BasicFileAttributes attrs = Files.readAttributes(dir, BasicFileAttributes) 
        
        println """
        Directory name: ${dir.fileName}
        Absolute path: ${dir.toAbsolutePath()}
        
        The file exists: ${Files.exists(dir)}
        The file is readable: ${Files.isReadable(dir)}
        The file is writable: ${Files.isWritable(dir)}
        The file is executable: ${Files.isExecutable(dir)}
        The file is a directory: ${Files.isDirectory(dir)}
        
        Created: ${attrs.creationTime()}
        Last modified: ${attrs.lastModifiedTime()}
        Last accessed: ${attrs.lastAccessTime()}
        
        Children:"""
        
        
        dir.eachFile {
            println "  - ${it.fileName}"
        }
    }

    def createOrUpdate(directory, fileName, extension, infoList) {
        if(directory == null)  directory = System.getProperty("user.dir")
        new File("$directory/$fileName$extension").withWriter { out ->
        out.println infoList
        }
    }
}
