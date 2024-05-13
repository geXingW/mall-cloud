package com.gexingw.mall.common.core.util;

import com.gexingw.mall.common.core.support.DiffChange;
import com.gexingw.mall.common.core.support.ModifyChange;
import com.gexingw.mall.common.core.support.NewChange;
import com.gexingw.mall.common.core.support.RemoveChange;
import org.javers.core.Changes;
import org.javers.core.Javers;
import org.javers.core.JaversBuilder;
import org.javers.core.diff.Change;
import org.javers.core.diff.changetype.*;

import java.util.*;

/**
 * mall-cloud
 *
 * @author GeXingW
 * @date 2024/5/12 14:08
 */
public class DiffUtil {

//    public static Changes diff(Object before, Object after) {
//
//        Javers javers = JaversBuilder.javers().build();
//        return javers.compare(before, after).getChanges();
//    }

    public static Map<String, List<DiffChange>> diff(Object before, Object after) {
        Javers javers = JaversBuilder.javers().build();
        Changes changes = javers.compare(before, after).getChanges();
        if (changes.isEmpty()) {
            return Collections.emptyMap();
        }

        HashMap<String, List<DiffChange>> diffChanges = new HashMap<>();
        for (Change change : changes) {
            String className = change.getAffectedGlobalId().getTypeName();
            List<DiffChange> classChanges = diffChanges.getOrDefault(className, new ArrayList<>());

            if (change instanceof InitialValueChange || change instanceof TerminalValueChange) {
                continue;
            }

            if (change instanceof NewObject) {
                classChanges.add(new NewChange(null, change.getAffectedObject().orElse(null)));
            }

            if (change instanceof ObjectRemoved) {
                classChanges.add(new RemoveChange(change.getAffectedObject().orElse(null), null));
            }

            if (change instanceof ValueChange) {
                ValueChange valueChange = (ValueChange) change;
                classChanges.add(new ModifyChange((Long) valueChange.getAffectedLocalId(), valueChange.getPropertyName(), valueChange.getLeft(), valueChange.getRight()));
            }

            diffChanges.put(className, classChanges);
        }

        return diffChanges;
    }

}
