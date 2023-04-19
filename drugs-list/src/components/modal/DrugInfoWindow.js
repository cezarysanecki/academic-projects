import React, { memo } from 'react';

export const DrugInfoWindow = memo(({ drug, modalWindowTitle }) => {
    let activeSubstance1;
    let activeSubstance2;
    let activeSubstance3;

    if (drug && drug.sub1name !== '') {
        activeSubstance1 = 
            <div className="row mb-3">
                <div className="col-sm">
                    <p className="h6">Substancja czynna: <span className="font-weight-normal">{ drug.sub1name } - { drug.sub1amount }</span></p>
                </div>
            </div>
    }

    if (drug && drug.sub2name !== '') {
        activeSubstance2 = 
            <div className="row mb-3">
                <div className="col-sm">
                    <p className="h6">Substancja czynna: <span className="font-weight-normal">{ drug.sub2name } - { drug.sub2amount }</span></p>
                </div>
            </div>
    }

    if (drug && drug.sub3name !== '') {
        activeSubstance3 = 
            <div className="row mb-3">
                <div className="col-sm">
                    <p className="h6">Substancja czynna: <span className="font-weight-normal">{ drug.sub3name } - { drug.sub3amount }</span></p>
                </div>
            </div>
    }

    return (
        <div className="modal fade" id="drugInfoModalForm" tabIndex="-1" role="dialog" aria-labelledby="drugInfoModalForm" aria-hidden="true">
            <div className="modal-dialog modal-dialog-centered" role="document">
                <div className="modal-content">
                    <div className="modal-header">
                        <h5 className="modal-title" id="drugInfoModalFormTitle">{ modalWindowTitle }</h5>
                        <button type="button" className="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div className="modal-body">
                        <div className="container-fluid">
                            <div className="row mb-3">
                                <div className="col-sm">
                                    <img src={ drug.imageUrl } alt={ drug.name } className="img-thumbnail" />
                                </div>
                                <div className="col-sm">
                                    <p className="font-weight-light" id="drugInfoName"><span className="h6">Nazwa: </span>{ drug.name }</p>
                                    <p className="font-weight-light" id="drugInfoPrice"><span className="h6">Cena: </span>{ drug.price }zł</p>
                                    <p className="font-weight-light" id="drugInfoProducer"><span className="h6">Producent: </span>{ drug.producer }</p>
                                    <p className="font-weight-light" id="drugInfoFormulation"><span className="h6">Postać leku: </span>{ drug.formulation }</p>
                                </div>
                            </div>
                            <div className="row mb-3">
                                <div className="col-sm">
                                    <p className="h6">Opis leku: </p>
                                    <p className="font-weight-light">{ drug.description }</p>
                                </div>
                            </div>
                            <div className="row mb-3">
                                <div className="col-sm">
                                    <p className="h6">Działanie: </p>
                                    <p className="font-weight-light">{ drug.drugEffect }</p>
                                </div>
                            </div>                           
                            { activeSubstance1 }
                            { activeSubstance2 }
                            { activeSubstance3 }
                        </div>
                    </div>
                    <div className="modal-footer">
                        <button type="button" className="btn btn-info" data-dismiss="modal">Wyjdź</button>
                    </div>
                </div>
            </div>
        </div>
    );  
});