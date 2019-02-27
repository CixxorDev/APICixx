package be.cixxor.api.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.minecraft.server.v1_8_R3.BiomeBase;
import net.minecraft.server.v1_8_R3.BiomeBase.BiomeMeta;
import net.minecraft.server.v1_8_R3.EntityInsentient;
import net.minecraft.server.v1_8_R3.EntityTypes;

public class NMS {
	public static void registerEntity(String name, int id, Class<? extends EntityInsentient> nmsClass, Class<? extends EntityInsentient> customClass) {
		
		try {
			List<Map<?,?>> dataMaps = new ArrayList<Map<?,?>>();
			for(Field f : EntityTypes.class.getDeclaredFields()) {
				if(f.getType().getSimpleName().equals(Map.class.getSimpleName())) {
					f.setAccessible(true);
					dataMaps.add((Map<?,?>) f.get(null));
				}
			}
			
			if(dataMaps.get(2).containsKey(id)){
				dataMaps.get(0).remove(name);
				dataMaps.get(2).remove(id);
			}
			
			Method method = EntityTypes.class.getDeclaredMethod("a", Class.class, String.class, int.class);
			method.setAccessible(true);
			method.invoke(null, customClass, name, id);
			for(Field field : BiomeBase.class.getDeclaredFields()) {
				if(field.getType().getSimpleName().equals(List.class.getSimpleName())) {
				if(field.get(null) != null) {
					for(Field list: BiomeBase.class.getDeclaredFields()) {
						if(list.getType().getSimpleName().equals(List.class.getSimpleName())) {
							list.setAccessible(true);
							@SuppressWarnings("unchecked")
							List<BiomeMeta> MetaList = (List<BiomeMeta>) list.get(field.get(null));
							
							for(BiomeMeta meta : MetaList) {
								Field clas = BiomeMeta.class.getDeclaredFields()[0];
								if(clas.get(meta).equals(nmsClass)){
									clas.set(meta, customClass);
								}
							}
						}
					}
				}
				}
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
