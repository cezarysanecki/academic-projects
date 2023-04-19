import React, { memo } from 'react';

export const DrugRow = memo(({ drug, onDeleteDrug, showFormEditDrug, showInfoDrugWindow }) => {
    return (
        <tr>
            <th scope="row">{ drug.id }</th>
            <td className="drugInfo" onClick={ () => showInfoDrugWindow(drug.id) } data-toggle="modal" data-target="#drugInfoModalForm">{ drug.name }</td>
            <td>{ drug.price } zł</td>
            <td>{ drug.producer }</td>
            <td>
                <button onClick={ () => showFormEditDrug(drug.id) } className="btn btn-warning mr-2" data-toggle="modal" data-target="#drugModalForm">Edytuj</button>
                <button onClick={ () => onDeleteDrug(drug.id) } className="btn btn-danger">Usuń</button>
            </td>
        </tr>
    );
});