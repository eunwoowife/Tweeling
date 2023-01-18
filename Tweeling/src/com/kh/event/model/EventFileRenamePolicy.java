package com.kh.event.model;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class EventFileRenamePolicy implements FileRenamePolicy {
    
    @Override
    public File rename(File originFile) {
        String originName = originFile.getName();
        String event = new String("event");
        String currentTime = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String bar = new String("-");
        int ranNum = (int)(Math.random() * 90000) + 10000;
        String ext = originName.substring(originName.lastIndexOf("."));
        String changeName = event + currentTime + bar + ranNum + ext;
        File f = new File(originFile.getParent(), changeName);
        return f;
    }

}
