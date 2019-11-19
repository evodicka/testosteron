<div class="card">
	<header class="card-header has-background-info">
		<p class="card-header-title">Environment - PROPS</p>
	</header>
	<div class="card-content">
		<div class="content">
			<table class="table is-striped is-fullwidth is-narrow">
				<tbody>
					<#list envInfo.props as it>
					<tr><th>${it.key}</th><td>${it.val}</td></tr>
					</#list>
				</tbody>
			</table>
		</div>
	</div>
</div>

<div class="card">
	<header class="card-header has-background-info">
		<p class="card-header-title">Environment - ENV</p>
	</header>
	<div class="card-content">
		<div class="content">
			<table class="table is-striped is-fullwidth is-narrow">
				<tbody>
					<#list envInfo.envs as it>
					<tr><th>${it.key}</th><td>${it.val}</td></tr>
					</#list>
				</tbody>
			</table>
		</div>
	</div>
</div>
