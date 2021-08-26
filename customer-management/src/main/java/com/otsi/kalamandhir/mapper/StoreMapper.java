/**
 * mapper for Store
 */
package com.otsi.kalamandhir.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.otsi.kalamandhir.model.Store;
import com.otsi.kalamandhir.vo.StoreVo;

/**
 * @author vasavi
 *
 */
@Component
public class StoreMapper {

	/*
	 * EntityToVo converts dto to vo
	 * 
	 */

	public StoreVo EntityToVo(Store dto) {
		StoreVo vo = new StoreVo();
		vo.setId(dto.getId());
		vo.setStoreName(dto.getStoreName());
       return vo;
	}
	
	/*
	 * list of EntityToVo to convert dto's to vo's
	 */
	public List<StoreVo> EntityToVo(List<Store> dtos) {
		return dtos.stream().map(dto -> EntityToVo(dto)).collect(Collectors.toList());

	}

	/*
	 * mapVoToEntity converts vo to dto
	 * 
	 */

	public Store mapVoToEntity(StoreVo vo) {

		Store dto = new Store();
		dto.setId(vo.getId());
		dto.setStoreName(vo.getStoreName());
		return dto;

	}
	/*
	 * list of mapVoToEntity to convert vo's to dto's
	 */
	public List<Store> mapVoToEntity(List<StoreVo> vos) {
		return vos.stream().map(vo -> mapVoToEntity(vo)).collect(Collectors.toList());

	}

}
