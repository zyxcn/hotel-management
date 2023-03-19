package cn.edu.sut.hotel_management.util;

import cn.edu.sut.hotel_management.sql.insert;
import cn.edu.sut.hotel_management.sql.select;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.*;
import java.sql.SQLException;

public class ImageUtil {
    public static ImageIcon createAutoAdjustIcon(java.awt.Image image, boolean constrained) {
        ImageIcon icon = new ImageIcon(image) {
            @Override
            public synchronized void paintIcon(java.awt.Component cmp, Graphics g, int x, int y) {
                //初始化参数
                Point startPoint = new Point(0, 0);//默认绘制起点
                Dimension cmpSize = cmp.getSize();//获取组件大小
                Dimension imgSize = new Dimension(getIconWidth(), getIconHeight());//获取图像大小
                //计算绘制起点和区域
                if (constrained) {//等比例缩放
                    //计算图像宽高比例
                    double ratio = 1.0 * imgSize.width / imgSize.height;
                    //计算等比例缩放后的区域大小
                    imgSize.width = (int) Math.min(cmpSize.width, ratio * cmpSize.height);
                    imgSize.height = (int) (imgSize.width / ratio);
                    //计算绘制起点
                    startPoint.x = (int)
                            (cmp.getAlignmentX() * (cmpSize.width - imgSize.width));
                    startPoint.y = (int)
                            (cmp.getAlignmentY() * (cmpSize.height - imgSize.height));
                } else {//完全填充
                    imgSize = cmpSize;
                }
                //根据起点和区域大小进行绘制
                if (getImageObserver() == null) {
                    g.drawImage(getImage(), startPoint.x, startPoint.y,
                            imgSize.width, imgSize.height, cmp);
                } else {
                    g.drawImage(getImage(), startPoint.x, startPoint.y,
                            imgSize.width, imgSize.height, getImageObserver());
                }
            }
        };
        return icon;
    }

    public static ImageIcon createAutoAdjustIcon(String filename, boolean constrained) {
        return createAutoAdjustIcon(new ImageIcon(filename).getImage(), constrained);
    }

    public static ImageIcon createAutoAdjustIcon(byte[] img_aray, boolean constrained) {
        return createAutoAdjustIcon(new ImageIcon(img_aray).getImage(), constrained);
    }

    public static int addPicture(JLabel lblNewLabel, JButton button) {
        JFileChooser chooser = new JFileChooser();
        chooser.setMultiSelectionEnabled(true);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("图像文件(jpg/png/gif)", "jpg", "jpeg", "png", "gif");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(button);
        String absolutePath = null;
        int idx = 0;
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File[] arrfiles = chooser.getSelectedFiles();
            if (arrfiles == null || arrfiles.length == 0) {
                return -1;
            }
            File ff = chooser.getSelectedFile();
            String fileName = ff.getName();
            String prefix = fileName.substring(fileName.lastIndexOf(".") + 1);
            if (!(prefix.equals("jpg") || prefix.equals("png") || prefix.equals("gif"))) {
                JOptionPane.showMessageDialog(new JDialog(), ":请选择.jpg 或 .png 或 .gif 格式的图片");
                return -1;
            }
            FileInputStream input = null;
            try {
                for (File f : arrfiles) {
                    absolutePath = chooser.getSelectedFile().getAbsolutePath();
                    ImageIcon imageIcon = ImageUtil.createAutoAdjustIcon(absolutePath, true);
                    lblNewLabel.setIcon(imageIcon);
                    idx = insert.addPicture(absolutePath);
                    input = new FileInputStream(f);
                    input.close();
                }
                JOptionPane.showMessageDialog(null, "上传成功！", "提示",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (FileNotFoundException e1) {
                JOptionPane.showMessageDialog(null, "上传失败！", "提示",
                        JOptionPane.ERROR_MESSAGE);
                e1.printStackTrace();
            } catch (IOException e1) {
                JOptionPane.showMessageDialog(null, "上传失败！", "提示",
                        JOptionPane.ERROR_MESSAGE);
                e1.printStackTrace();
            }
        }
        return idx;
    }

    public static boolean loadPicture(JLabel lblNewLabel) throws IOException {
        try {
            InputStream img = select.loadPicture();
            if (img == null) {
                return false;
            }
            byte[] img_array = new byte[img.available()];
            img.read(img_array);
            if (img_array.length == 0) {
                return false;
            }
            ImageIcon imageIcon = ImageUtil.createAutoAdjustIcon(img_array, true);
            lblNewLabel.setIcon(imageIcon);
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
