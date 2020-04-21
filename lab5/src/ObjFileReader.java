import com.sun.j3d.loaders.Scene;
import com.sun.j3d.loaders.objectfile.ObjectFile;

import javax.media.j3d.Appearance;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Node;
import javax.media.j3d.Shape3D;
import java.util.Hashtable;

public class ObjFileReader extends BranchGroup {
    public ObjFileReader(String filePath, String name, Appearance appearance){
        BranchGroup branchGroup = new BranchGroup();
        int flags = ObjectFile.RESIZE;
        double creaseAngle = 60.0;
        ObjectFile objFile = new ObjectFile(flags, (float)(creaseAngle *Math.PI)/180);
        Scene scene = null;
        try {
            scene = objFile.load(filePath);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("OBJ load Err：" + e.getMessage());
        }
        branchGroup.addChild(scene.getSceneGroup());

        Hashtable<String, Shape3D> map = scene.getNamedObjects();
        map.get(name).setAppearance(appearance);
        this.addChild(branchGroup);
    }
}