// Configuração da API
const API_BASE_URL = '/api';

// Estado da aplicação
let currentSection = 'home';
let jovens = [];
let especialidades = [];

// Inicialização
document.addEventListener('DOMContentLoaded', function() {
    showSection('home');
    loadInitialData();
    setupEventListeners();
});

// Event Listeners
function setupEventListeners() {
    // Busca de jovens
    document.getElementById('search-jovem').addEventListener('input', function() {
        filterJovens();
    });

    // Filtro tipo sanguíneo
    document.getElementById('filter-tipo-sanguineo').addEventListener('change', function() {
        filterJovens();
    });

    // Filtro nível especialidades
    document.getElementById('filter-nivel').addEventListener('change', function() {
        filterEspecialidades();
    });

    // Mudança de especialidade no modal de requisito
    document.getElementById('requisito-especialidade').addEventListener('change', function() {
        loadRequisitosPorEspecialidade(this.value);
    });
}

// Navegação entre seções
function showSection(sectionName) {
    // Esconder todas as seções
    document.querySelectorAll('.section').forEach(section => {
        section.classList.add('hidden');
    });

    // Mostrar seção selecionada
    document.getElementById(sectionName + '-section').classList.remove('hidden');
    currentSection = sectionName;

    // Carregar dados específicos da seção
    switch(sectionName) {
        case 'home':
            loadStats();
            break;
        case 'jovens':
            loadJovens();
            break;
        case 'especialidades':
            loadEspecialidades();
            break;
        case 'progressao':
            loadJovensForSelect();
            break;
        case 'relatorios':
            break;
    }
}

// Carregamento inicial de dados
async function loadInitialData() {
    try {
        await Promise.all([
            loadJovensData(),
            loadEspecialidadesData()
        ]);
    } catch (error) {
        console.error('Erro ao carregar dados iniciais:', error);
        showAlert('Erro ao carregar dados iniciais', 'danger');
    }
}

// Carregamento de estatísticas
async function loadStats() {
    try {
        const [jovensResponse, especialidadesResponse] = await Promise.all([
            fetch(`${API_BASE_URL}/jovens`),
            fetch(`${API_BASE_URL}/especialidades`)
        ]);

        const jovens = await jovensResponse.json();
        const especialidades = await especialidadesResponse.json();

        document.getElementById('total-jovens').textContent = jovens.length;
        document.getElementById('total-especialidades').textContent = especialidades.length;

        // Simular outros dados
        document.getElementById('total-requisitos').textContent = jovens.length * 5; // Média de 5 requisitos por jovem
        document.getElementById('jovens-cruzeiro').textContent = Math.floor(jovens.length * 0.1); // 10% dos jovens

    } catch (error) {
        console.error('Erro ao carregar estatísticas:', error);
    }
}

// === GESTÃO DE JOVENS ===

async function loadJovensData() {
    try {
        const response = await fetch(`${API_BASE_URL}/jovens`);
        jovens = await response.json();
        return jovens;
    } catch (error) {
        console.error('Erro ao carregar jovens:', error);
        throw error;
    }
}

async function loadJovens() {
    showLoading('jovens-loading');
    try {
        await loadJovensData();
        displayJovens(jovens);
    } catch (error) {
        showAlert('Erro ao carregar jovens', 'danger');
    } finally {
        hideLoading('jovens-loading');
    }
}

function displayJovens(jovensToShow) {
    const tbody = document.getElementById('jovens-tbody');
    tbody.innerHTML = '';

    jovensToShow.forEach(jovem => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>
                <strong>${jovem.nome}</strong>
                <br>
                <small class="text-muted">${jovem.contato ? jovem.contato.email : 'Email não informado'}</small>
            </td>
            <td>${formatDate(jovem.dataNasc)}</td>
            <td>
                <span class="badge bg-info">${jovem.tipoSanguineo}</span>
            </td>
            <td>${formatDate(jovem.dataEntrada)}</td>
            <td>
                <button class="btn btn-sm btn-outline-primary me-1" onclick="editJovem(${jovem.idJovem})" title="Editar">
                    <i class="fas fa-edit"></i>
                </button>
                <button class="btn btn-sm btn-outline-info me-1" onclick="viewProgressao(${jovem.idJovem})" title="Ver Progressão">
                    <i class="fas fa-chart-line"></i>
                </button>
                <button class="btn btn-sm btn-outline-danger" onclick="deleteJovem(${jovem.idJovem})" title="Excluir">
                    <i class="fas fa-trash"></i>
                </button>
            </td>
        `;
        tbody.appendChild(row);
    });
}

function filterJovens() {
    const searchTerm = document.getElementById('search-jovem').value.toLowerCase();
    const tipoSanguineo = document.getElementById('filter-tipo-sanguineo').value;

    let filtered = jovens.filter(jovem => {
        const matchesSearch = jovem.nome.toLowerCase().includes(searchTerm);
        const matchesTipo = !tipoSanguineo || jovem.tipoSanguineo === tipoSanguineo;
        return matchesSearch && matchesTipo;
    });

    displayJovens(filtered);
}

function showJovemModal(jovem = null) {
    const modal = new bootstrap.Modal(document.getElementById('jovemModal'));
    const title = document.getElementById('jovem-modal-title');
    
    if (jovem) {
        title.textContent = 'Editar Jovem';
        fillJovemForm(jovem);
    } else {
        title.textContent = 'Novo Jovem';
        clearJovemForm();
    }
    
    modal.show();
}

function fillJovemForm(jovem) {
    document.getElementById('jovem-id').value = jovem.idJovem;
    document.getElementById('jovem-nome').value = jovem.nome;
    document.getElementById('jovem-data-nasc').value = formatDateForInput(jovem.dataNasc);
    document.getElementById('jovem-data-entrada').value = formatDateForInput(jovem.dataEntrada);
    document.getElementById('jovem-tipo-sanguineo').value = jovem.tipoSanguineo;
    document.getElementById('jovem-alergias').value = jovem.alergias || '';
    
    if (jovem.contato) {
        document.getElementById('contato-telefone').value = jovem.contato.telefone;
        document.getElementById('contato-endereco').value = jovem.contato.endereco;
        document.getElementById('contato-email').value = jovem.contato.email;
    }
}

function clearJovemForm() {
    document.getElementById('jovem-form').reset();
    document.getElementById('jovem-id').value = '';
}

async function salvarJovem() {
    const form = document.getElementById('jovem-form');
    if (!form.checkValidity()) {
        form.reportValidity();
        return;
    }

    const jovemData = {
        nome: document.getElementById('jovem-nome').value,
        dataNasc: document.getElementById('jovem-data-nasc').value,
        dataEntrada: document.getElementById('jovem-data-entrada').value,
        tipoSanguineo: document.getElementById('jovem-tipo-sanguineo').value,
        alergias: document.getElementById('jovem-alergias').value || 'Nenhuma',
        contato: {
            telefone: document.getElementById('contato-telefone').value,
            endereco: document.getElementById('contato-endereco').value,
            email: document.getElementById('contato-email').value
        }
    };

    try {
        const jovemId = document.getElementById('jovem-id').value;
        const url = jovemId ? `${API_BASE_URL}/jovens/${jovemId}` : `${API_BASE_URL}/jovens`;
        const method = jovemId ? 'PUT' : 'POST';

        const response = await fetch(url, {
            method: method,
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(jovemData)
        });

        if (response.ok) {
            showAlert(jovemId ? 'Jovem atualizado com sucesso!' : 'Jovem cadastrado com sucesso!', 'success');
            bootstrap.Modal.getInstance(document.getElementById('jovemModal')).hide();
            loadJovens();
        } else {
            throw new Error('Erro ao salvar jovem');
        }
    } catch (error) {
        console.error('Erro ao salvar jovem:', error);
        showAlert('Erro ao salvar jovem', 'danger');
    }
}

async function editJovem(id) {
    try {
        const response = await fetch(`${API_BASE_URL}/jovens/${id}`);
        const jovem = await response.json();
        showJovemModal(jovem);
    } catch (error) {
        console.error('Erro ao carregar jovem:', error);
        showAlert('Erro ao carregar dados do jovem', 'danger');
    }
}

async function deleteJovem(id) {
    if (!confirm('Tem certeza que deseja excluir este jovem?')) {
        return;
    }

    try {
        const response = await fetch(`${API_BASE_URL}/jovens/${id}`, {
            method: 'DELETE'
        });

        if (response.ok) {
            showAlert('Jovem excluído com sucesso!', 'success');
            loadJovens();
        } else {
            throw new Error('Erro ao excluir jovem');
        }
    } catch (error) {
        console.error('Erro ao excluir jovem:', error);
        showAlert('Erro ao excluir jovem', 'danger');
    }
}

function viewProgressao(id) {
    document.getElementById('select-jovem-progressao').value = id;
    showSection('progressao');
    loadProgressaoJovem();
}

// === GESTÃO DE ESPECIALIDADES ===

async function loadEspecialidadesData() {
    try {
        const response = await fetch(`${API_BASE_URL}/especialidades`);
        especialidades = await response.json();
        return especialidades;
    } catch (error) {
        console.error('Erro ao carregar especialidades:', error);
        throw error;
    }
}

async function loadEspecialidades() {
    showLoading('especialidades-loading');
    try {
        await loadEspecialidadesData();
        displayEspecialidades(especialidades);
    } catch (error) {
        showAlert('Erro ao carregar especialidades', 'danger');
    } finally {
        hideLoading('especialidades-loading');
    }
}

function displayEspecialidades(especialidadesToShow) {
    const container = document.getElementById('especialidades-container');
    container.innerHTML = '';

    especialidadesToShow.forEach(esp => {
        const card = document.createElement('div');
        card.className = 'col-md-6 col-lg-4 mb-3';
        card.innerHTML = `
            <div class="card h-100">
                <div class="card-header bg-primary text-white">
                    <h6 class="mb-0">
                        <i class="fas fa-medal me-2"></i>
                        ${esp.descricao}
                    </h6>
                </div>
                <div class="card-body">
                    <div class="mb-2">
                        <span class="badge bg-info">Nível ${esp.nivel}</span>
                        <span class="badge bg-secondary">${esp.totalRequisitos} requisitos</span>
                    </div>
                    <p class="card-text">
                        <small class="text-muted">
                            Área: ${esp.areaConhecimento ? esp.areaConhecimento.nome : 'Não definida'}
                        </small>
                    </p>
                </div>
                <div class="card-footer">
                    <button class="btn btn-sm btn-outline-primary" onclick="editEspecialidade(${esp.idEspecialidade})">
                        <i class="fas fa-edit me-1"></i>Editar
                    </button>
                    <button class="btn btn-sm btn-outline-danger" onclick="deleteEspecialidade(${esp.idEspecialidade})">
                        <i class="fas fa-trash me-1"></i>Excluir
                    </button>
                </div>
            </div>
        `;
        container.appendChild(card);
    });
}

function filterEspecialidades() {
    const nivel = document.getElementById('filter-nivel').value;
    
    let filtered = especialidades;
    if (nivel) {
        filtered = especialidades.filter(esp => esp.nivel.toString() === nivel);
    }
    
    displayEspecialidades(filtered);
}

// === PROGRESSÃO ===

async function loadJovensForSelect() {
    try {
        if (jovens.length === 0) {
            await loadJovensData();
        }
        
        const select = document.getElementById('select-jovem-progressao');
        select.innerHTML = '<option value="">Selecione um jovem...</option>';
        
        jovens.forEach(jovem => {
            const option = document.createElement('option');
            option.value = jovem.idJovem;
            option.textContent = jovem.nome;
            select.appendChild(option);
        });

        // Também popular o select do modal de requisitos
        const requisitoSelect = document.getElementById('requisito-jovem');
        requisitoSelect.innerHTML = '<option value="">Selecione um jovem...</option>';
        
        jovens.forEach(jovem => {
            const option = document.createElement('option');
            option.value = jovem.idJovem;
            option.textContent = jovem.nome;
            requisitoSelect.appendChild(option);
        });

        // Popular especialidades no modal
        const espSelect = document.getElementById('requisito-especialidade');
        espSelect.innerHTML = '<option value="">Selecione uma especialidade...</option>';
        
        if (especialidades.length === 0) {
            await loadEspecialidadesData();
        }
        
        especialidades.forEach(esp => {
            const option = document.createElement('option');
            option.value = esp.idEspecialidade;
            option.textContent = esp.descricao;
            espSelect.appendChild(option);
        });

    } catch (error) {
        console.error('Erro ao carregar jovens para select:', error);
    }
}

async function loadProgressaoJovem() {
    const jovemId = document.getElementById('select-jovem-progressao').value;
    if (!jovemId) {
        showAlert('Selecione um jovem primeiro', 'warning');
        return;
    }

    showLoading('progressao-loading');
    try {
        const response = await fetch(`${API_BASE_URL}/progressao/jovem/${jovemId}`);
        const progressao = await response.json();
        
        displayProgressaoJovem(progressao);
        document.getElementById('progressao-content').classList.remove('hidden');
    } catch (error) {
        console.error('Erro ao carregar progressão:', error);
        showAlert('Erro ao carregar progressão do jovem', 'danger');
    } finally {
        hideLoading('progressao-loading');
    }
}

function displayProgressaoJovem(progressao) {
    // Informações do jovem
    const jovemInfo = document.getElementById('jovem-info');
    jovemInfo.innerHTML = `
        <div class="row">
            <div class="col-md-6">
                <strong>Nome:</strong> ${progressao.jovem.nome}<br>
                <strong>Data de Nascimento:</strong> ${formatDate(progressao.jovem.dataNasc)}<br>
                <strong>Tipo Sanguíneo:</strong> <span class="badge bg-info">${progressao.jovem.tipoSanguineo}</span>
            </div>
            <div class="col-md-6">
                <strong>Data de Entrada:</strong> ${formatDate(progressao.jovem.dataEntrada)}<br>
                <strong>Alergias:</strong> ${progressao.jovem.alergias}<br>
                <strong>Contato:</strong> ${progressao.jovem.contato ? progressao.jovem.contato.telefone : 'Não informado'}
            </div>
        </div>
    `;

    // Progressão das especialidades
    const especialidadesProgress = document.getElementById('especialidades-progress');
    especialidadesProgress.innerHTML = '<h5><i class="fas fa-chart-bar me-2"></i>Progresso nas Especialidades</h5>';

    progressao.especialidades.forEach(esp => {
        const especialidade = esp.especialidade;
        const nivel = esp.nivel;
        const percentual = esp.percentual;
        
        let badgeClass = 'bg-secondary';
        if (nivel === 3) badgeClass = 'bg-success';
        else if (nivel === 2) badgeClass = 'bg-warning';
        else if (nivel === 1) badgeClass = 'bg-info';

        const card = document.createElement('div');
        card.className = 'card mb-3';
        card.innerHTML = `
            <div class="card-body">
                <div class="d-flex justify-content-between align-items-center mb-2">
                    <h6 class="mb-0">${especialidade.descricao}</h6>
                    <span class="badge ${badgeClass}">Nível ${nivel}</span>
                </div>
                <div class="progress mb-2" style="height: 10px;">
                    <div class="progress-bar" role="progressbar" style="width: ${percentual}%"></div>
                </div>
                <small class="text-muted">
                    ${esp.requisitosCompletos} de ${esp.totalRequisitos} requisitos completos (${percentual.toFixed(1)}%)
                </small>
            </div>
        `;
        especialidadesProgress.appendChild(card);
    });
}

// Modal de registrar requisito
function showRegistrarRequisitoModal() {
    const modal = new bootstrap.Modal(document.getElementById('registrarRequisitoModal'));
    modal.show();
}

async function loadRequisitosPorEspecialidade(especialidadeId) {
    if (!especialidadeId) {
        document.getElementById('requisito-item').innerHTML = '<option value="">Selecione um requisito...</option>';
        return;
    }

    try {
        // Esta é uma implementação simplificada
        // Na prática, você precisaria de um endpoint para buscar requisitos por especialidade
        const select = document.getElementById('requisito-item');
        select.innerHTML = '<option value="">Carregando requisitos...</option>';
        
        // Simular requisitos (você deve implementar o endpoint real)
        setTimeout(() => {
            select.innerHTML = `
                <option value="">Selecione um requisito...</option>
                <option value="1">Requisito 1 da especialidade</option>
                <option value="2">Requisito 2 da especialidade</option>
                <option value="3">Requisito 3 da especialidade</option>
            `;
        }, 500);
        
    } catch (error) {
        console.error('Erro ao carregar requisitos:', error);
    }
}

async function registrarRequisito() {
    const jovemId = document.getElementById('requisito-jovem').value;
    const requisitoId = document.getElementById('requisito-item').value;

    if (!jovemId || !requisitoId) {
        showAlert('Preencha todos os campos obrigatórios', 'warning');
        return;
    }

    try {
        const response = await fetch(`${API_BASE_URL}/progressao/requisito`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                idJovem: parseInt(jovemId),
                idRequisito: parseInt(requisitoId)
            })
        });

        if (response.ok) {
            showAlert('Requisito registrado com sucesso!', 'success');
            bootstrap.Modal.getInstance(document.getElementById('registrarRequisitoModal')).hide();
            
            // Atualizar progressão se estiver visualizando o mesmo jovem
            const currentJovem = document.getElementById('select-jovem-progressao').value;
            if (currentJovem === jovemId) {
                loadProgressaoJovem();
            }
        } else {
            throw new Error('Erro ao registrar requisito');
        }
    } catch (error) {
        console.error('Erro ao registrar requisito:', error);
        showAlert('Erro ao registrar requisito', 'danger');
    }
}

// === RELATÓRIOS ===

async function loadRelatoriosCruzeiroDoSul() {
    try {
        const response = await fetch(`${API_BASE_URL}/progressao/cruzeiro-do-sul`);
        const jovensAptos = await response.json();
        
        const content = document.getElementById('relatorios-content');
        content.innerHTML = `
            <div class="card">
                <div class="card-header bg-success text-white">
                    <h5 class="mb-0"><i class="fas fa-trophy me-2"></i>Jovens Aptos ao Cruzeiro do Sul</h5>
                </div>
                <div class="card-body">
                    ${jovensAptos.length === 0 ? 
                        '<p class="text-muted">Nenhum jovem atende aos requisitos no momento.</p>' :
                        jovensAptos.map(item => `
                            <div class="d-flex justify-content-between align-items-center border-bottom py-2">
                                <div>
                                    <strong>${item.jovem.nome}</strong><br>
                                    <small class="text-muted">Entrada: ${formatDate(item.jovem.dataEntrada)}</small>
                                </div>
                                <div class="text-end">
                                    <span class="badge bg-success">${item.requisitosCompletos} requisitos</span>
                                </div>
                            </div>
                        `).join('')
                    }
                </div>
            </div>
        `;
    } catch (error) {
        console.error('Erro ao carregar relatório:', error);
        showAlert('Erro ao carregar relatório', 'danger');
    }
}

// === UTILITÁRIOS ===

function showLoading(elementId) {
    document.getElementById(elementId).classList.remove('hidden');
}

function hideLoading(elementId) {
    document.getElementById(elementId).classList.add('hidden');
}

function showAlert(message, type = 'info') {
    // Criar elemento de alerta
    const alertDiv = document.createElement('div');
    alertDiv.className = `alert alert-${type} alert-dismissible fade show position-fixed`;
    alertDiv.style.cssText = 'top: 20px; right: 20px; z-index: 9999; min-width: 300px;';
    alertDiv.innerHTML = `
        ${message}
        <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
    `;
    
    document.body.appendChild(alertDiv);
    
    // Remover automaticamente após 5 segundos
    setTimeout(() => {
        if (alertDiv.parentNode) {
            alertDiv.parentNode.removeChild(alertDiv);
        }
    }, 5000);
}

function formatDate(dateString) {
    if (!dateString) return '';
    const date = new Date(dateString);
    return date.toLocaleDateString('pt-BR');
}

function formatDateForInput(dateString) {
    if (!dateString) return '';
    const date = new Date(dateString);
    return date.toISOString().split('T')[0];
}

// Placeholder functions para funcionalidades não implementadas
function showEspecialidadeModal() {
    showAlert('Funcionalidade em desenvolvimento', 'info');
}

function editEspecialidade(id) {
    showAlert('Funcionalidade em desenvolvimento', 'info');
}

function deleteEspecialidade(id) {
    showAlert('Funcionalidade em desenvolvimento', 'info');
}

function loadEstatisticasGerais() {
    showAlert('Funcionalidade em desenvolvimento', 'info');
}