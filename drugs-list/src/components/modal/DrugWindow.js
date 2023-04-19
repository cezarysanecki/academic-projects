import React, { memo } from 'react';

export const DrugWindow = memo(({ exisitngId, onAddDrug, onEditDrug, submitBtnText, modalWindowTitle, drugForm, change }) => {
    const handleChange = (event) => {
        change(event);

        let confirmBtn = document.getElementById('confirmBtn');

        let error = document.getElementById(event.target.name + 'Error');
        if(error) {
            if(event.target.value === '') {
                error.classList.remove('hideErrorDiv');
            } else {
                error.classList.add('hideErrorDiv');
            }
        }
        
        if(validDrug()) {
            confirmBtn.setAttribute('data-dismiss', 'modal');
        } else {
            confirmBtn.removeAttribute('data-dismiss');
        }
    }

    const handleSubmit = () => {
        if(validDrug()) {
            submitDrug();
        }
    }

    const validDrug = () => {
        let valid = true;

        if(drugForm.name === '' || drugForm.price === '' || drugForm.description === '' || drugForm.imageUrl === '' ||
            drugForm.producer === '' || drugForm.formulation === '' || drugForm.sub1name === '' || drugForm.sub1amount === '' ||
            drugForm.drugEffect === '') {
                valid = false;
        }

        return valid;
    }

    const submitDrug = () => {
        if(exisitngId === -1) {
            onAddDrug({
                ...drugForm
            });
        } else {
            onEditDrug({ 
                ...drugForm,
                id: exisitngId,
            });
        }
    }

    return (
        <div className="modal fade" id="drugModalForm" tabIndex="-1" role="dialog" aria-labelledby="addDrugModalForm" aria-hidden="true">
            <div className="modal-dialog modal-dialog-centered" role="document">
                <div className="modal-content">
                    <div className="modal-header">
                        <h5 className="modal-title" id="addDrugModalForm">{ modalWindowTitle }</h5>
                        <button type="button" className="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div className="modal-body">
                        <input type="hidden" name="id" value={ exisitngId } />

                        <div className="container-fluid">
                            <div className="row">
                                <div className="input-group input-group-sm col-sm">
                                    <div className="input-group-prepend">
                                        <span className="input-group-text" id="drugName">Nazwa</span>
                                    </div>
                                    <input type="text" className="form-control" placeholder="Nazwa leku" 
                                        aria-label="Nazwa leku" aria-describedby="drugName" 
                                        name="name"
                                        value={ drugForm.name }
                                        onKeyUp={ event => handleChange(event) }
                                        onChange={ event => handleChange(event) } />
                                </div>
                                <div className="input-group input-group-sm col-sm">
                                    <div className="input-group-prepend">
                                        <span className="input-group-text" id="drugPrice">Cena</span>
                                    </div>
                                    <input type="number" step="0.01" min="0" className="form-control" placeholder="Cena" 
                                        aria-label="Cena" aria-describedby="drugPrice" 
                                        name="price"
                                        value={ drugForm.price }
                                        onKeyUp={ event => handleChange(event) }
                                        onChange={ event => handleChange(event) } />
                                </div>
                            </div>
                            <div className="row mb-3">
                                <div className="col-sm">
                                    <span className="error" id="nameError">Proszę podać nazwę leku</span>
                                </div>
                                <div className="col-sm">
                                    <span className="error" id="priceError">Proszę podać cenę leku</span>
                                </div>
                            </div>
                            <div className="row">
                                <div className="input-group input-group-sm col-sm">
                                    <div className="input-group-prepend">
                                        <span className="input-group-text">Opis leku</span>
                                    </div>
                                    <textarea className="form-control" aria-label="Opis leku"
                                        name="description"
                                        value={ drugForm.description }
                                        onKeyUp={ event => handleChange(event) }
                                        onChange={ event => handleChange(event) } >                    
                                    </textarea>
                                </div>
                            </div>
                            <div className="row mb-3">
                                <div className="col-sm">
                                    <span className="error" id="descriptionError">Proszę podać opis leku</span>
                                </div>
                            </div>
                            <div className="row">
                                <div className="input-group input-group-sm col-sm">
                                    <div className="input-group-prepend">
                                        <span className="input-group-text" id="drugImageUrl">Obraz URL</span>
                                    </div>
                                    <input type="text" className="form-control" placeholder="Obraz URL" 
                                        aria-label="Obraz URL" aria-describedby="drugImageUrl" 
                                        name="imageUrl"
                                        value={ drugForm.imageUrl }
                                        onKeyUp={ event => handleChange(event) }
                                        onChange={ event => handleChange(event) } />
                                </div>
                            </div>
                            <div className="row mb-3">
                                <div className="col-sm">
                                    <span className="error" id="imageUrlError">Proszę podać link do zdjęciu leku</span>
                                </div>
                            </div>
                            <div className="row">
                                <div className="input-group input-group-sm col-sm">
                                    <div className="input-group-prepend">
                                        <span className="input-group-text" id="drugProducer">Producent</span>
                                    </div>
                                    <input type="text" className="form-control" placeholder="Producent" 
                                        aria-label="Producent" aria-describedby="drugProducer" 
                                        name="producer"
                                        value={ drugForm.producer }
                                        onKeyUp={ event => handleChange(event) }
                                        onChange={ event => handleChange(event) } />
                                </div>
                                <div className="input-group input-group-sm col-sm">
                                    <div className="input-group-prepend">
                                        <span className="input-group-text" id="drugFormulation">Postać leku</span>
                                    </div>
                                    <input type="text" className="form-control" placeholder="Postać leku" 
                                        aria-label="Postać leku" aria-describedby="drugFormulation" 
                                        name="formulation" 
                                        value={ drugForm.formulation }
                                        onKeyUp={ event => handleChange(event) }
                                        onChange={ event => handleChange(event) } />
                                </div>
                            </div>
                            <div className="row mb-3">
                                <div className="col-sm">
                                    <span className="error" id="producerError">Proszę podać producenta leku</span>
                                </div>
                                <div className="col-sm">
                                    <span className="error" id="formulationError">Proszę podać ilość i postać leku</span>
                                </div>
                            </div>
                            <h6 className="my-2">1 Substancja aktywna:</h6>
                            <div className="row">
                                <div className="input-group input-group-sm col-sm">
                                    <div className="input-group-prepend">
                                        <span className="input-group-text" id="drugActiveSubstanceName1">Nazwa</span>
                                    </div>
                                    <input type="text" className="form-control" placeholder="Nazwa" 
                                        aria-label="Nazwa" aria-describedby="drugActiveSubstanceName1"
                                        name="sub1name" 
                                        value={ drugForm.sub1name }
                                        onKeyUp={ event => handleChange(event) }
                                        onChange={ event => handleChange(event) } />
                                </div>
                                <div className="input-group input-group-sm col-sm">
                                    <div className="input-group-prepend">
                                        <span className="input-group-text" id="drugActiveSubstanceAmount1">Ilość</span>
                                    </div>
                                    <input className="form-control" placeholder="Ilość" 
                                        aria-label="Ilość" aria-describedby="drugActiveSubstanceAmount1" 
                                        name="sub1amount"
                                        value={ drugForm.sub1amount }
                                        onKeyUp={ event => handleChange(event) }
                                        onChange={ event => handleChange(event) } />
                                </div>
                            </div>
                            <div className="row mb-3">
                                <div className="col-sm">
                                    <span className="error" id="sub1nameError">Proszę podać chociaż jedną substancję aktywną leku</span>
                                </div>
                            </div>
                            <h6 className="my-2">2 Substancja aktywna:</h6>
                            <div className="row mb-3">
                                <div className="input-group input-group-sm col-sm">
                                    <div className="input-group-prepend">
                                        <span className="input-group-text" id="drugActiveSubstanceName2">Nazwa</span>
                                    </div>
                                    <input type="text" className="form-control" placeholder="Nazwa" 
                                        aria-label="Nazwa" aria-describedby="drugActiveSubstanceName2" 
                                        name="sub2name" 
                                        value={ drugForm.sub2name }
                                        onKeyUp={ event => handleChange(event) }
                                        onChange={ event => handleChange(event) } />
                                </div>
                                <div className="input-group input-group-sm col-sm">
                                    <div className="input-group-prepend">
                                        <span className="input-group-text" id="drugActiveSubstanceAmount2">Ilość</span>
                                    </div>
                                    <input type="text" className="form-control" placeholder="Ilość" 
                                        aria-label="Ilość" aria-describedby="drugActiveSubstanceAmount2" 
                                        name="sub2amount"
                                        value={ drugForm.sub2amount }
                                        onKeyUp={ event => handleChange(event) }
                                        onChange={ event => handleChange(event) } />
                                </div>
                            </div>
                            <h6 className="my-2">3 Substancja aktywna:</h6>
                            <div className="row mb-3">
                                <div className="input-group input-group-sm col-sm">
                                    <div className="input-group-prepend">
                                        <span className="input-group-text" id="drugActiveSubstanceName3">Nazwa</span>
                                    </div>
                                    <input type="text" className="form-control" placeholder="Nazwa" 
                                        aria-label="Nazwa" aria-describedby="drugActiveSubstanceName3" 
                                        name="sub3name"
                                        value={ drugForm.sub3name }
                                        onKeyUp={ event => handleChange(event) }
                                        onChange={ event => handleChange(event) } />
                                </div>
                                <div className="input-group input-group-sm col-sm">
                                    <div className="input-group-prepend">
                                        <span className="input-group-text" id="drugActiveSubstanceAmount3">Ilość</span>
                                    </div>
                                    <input type="text" className="form-control" placeholder="Ilość" 
                                        aria-label="Ilość" aria-describedby="drugActiveSubstanceAmount3"
                                        name="sub3amount" 
                                        value={ drugForm.sub3amount }
                                        onKeyUp={ event => handleChange(event) }
                                        onChange={ event => handleChange(event) } />
                                </div>
                            </div>
                            <div className="row">
                                <div className="input-group input-group-sm col-sm">
                                    <div className="input-group-prepend">
                                        <span className="input-group-text">Działanie</span>
                                    </div>
                                    <textarea className="form-control" 
                                        aria-label="Działanie"
                                        name="drugEffect"
                                        value={ drugForm.drugEffect }
                                        onKeyUp={ event => handleChange(event) }
                                        onChange={ event => handleChange(event) } >
                                    </textarea>
                                </div>
                            </div>
                            <div className="row mb-3">
                                <div className="col-sm">
                                    <span className="error" id="drugEffectError">Proszę podać opis działania leku</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className="modal-footer">
                        <button id="confirmBtn" type="button" onClick={ handleSubmit } className="btn btn-warning" data-dismiss="modal">{ submitBtnText }</button>
                    </div>
                </div>
            </div>
        </div>
    );  
});