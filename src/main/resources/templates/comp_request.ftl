<div class="card">
	<header class="card-header has-background-warning">
		<p class="card-header-title">Request</p>
	</header>
	<div class="card-content">
		<div class="content">
			<table class="table is-striped is-fullwidth is-narrow">
				<thead><tr><th colspan="2">Basics</th></tr></thead>
				<tbody>
					<#list requestInfo.basics as it>
					<tr><th>${it.key}</th><td>${it.val}</td></tr>
					</#list>
				</tbody>
			</table>

			<table class="table is-striped is-fullwidth is-narrow">
				<thead><tr><th colspan="2">Headers</th></tr></thead>
				<tbody>
					<#list requestInfo.headers as it>
					<tr><th>${it.key}</th><td>${it.val}</td></tr>
					</#list>
				</tbody>
			</table>

		</div>
	</div>
</div>
	  